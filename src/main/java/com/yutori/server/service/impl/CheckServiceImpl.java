package com.yutori.server.service.impl;

import com.opencsv.CSVReader;
import com.yutori.server.domain.Sentence;
import com.yutori.server.domain.WrongAnswer;
import com.yutori.server.dto.*;
import com.yutori.server.exception.WrongAnswerNotFoundException;
import com.yutori.server.repository.SentenceRepository;
import com.yutori.server.repository.WrongAnswerRepository;
import com.yutori.server.service.CheckService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@PropertySource("classpath:sentence.properties")
public class CheckServiceImpl implements CheckService {

    private SentenceRepository sentenceRepository;
    private WrongAnswerRepository wrongAnswerRepository;
    private final static String DUST_TEXT="[\\s\u0000]+";
    
    @Autowired
    public void setSentenceRepository(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }
    
    @Autowired
    public void setWrongAnswerRepository(WrongAnswerRepository wrongAnswerRepository) {
        this.wrongAnswerRepository = wrongAnswerRepository;
    }
    
    @Value("${sentence.file.path}")
    private String dataFilePath;

    @Override
    public void loadSentence() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new ClassPathResource(dataFilePath).getInputStream(),
                            "euc-kr"
                    )
            );
            CSVReader reader = new CSVReader(bufferedReader);
            List<String[]> list = reader.readAll();

            for (String[] word : list) {
                word[1] = word[1].replaceAll(DUST_TEXT, "");
                word[2] = word[2].replaceAll(DUST_TEXT, "");
                word[3] = word[3].replaceAll(DUST_TEXT, "");

                SentenceTypes sentenceTypes = SentenceTypes.valueOf(word[1]);
                LevelTypes levelTypes = LevelTypes.valueOf(word[2]);
                NumTypes numTypes = NumTypes.valueOf(word[3]);

                Sentence sentence = Sentence.from(sentenceTypes, levelTypes, numTypes, word[4]);
                sentenceRepository.save(sentence);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<ResSentenceDto> getSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes) {
        List<ResSentenceDto> resSentenceDtos = sentenceRepository.findAllBySentenceTypesAndLevelTypesAndNumTypes(sentenceTypes, levelTypes, numTypes)
                .stream()
                .map(ResSentenceDto::from)
                .collect(Collectors.toList());

        return resSentenceDtos;
    }

    @Override
    public ResCheckListDto checkSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, Long userId, ReqCheckListDto reqCheckListDto) {
        List<ResSentenceDto> resSentenceDtos = getSentence(sentenceTypes, levelTypes, numTypes);
        ResSentenceListDto resSentenceListDto = new ResSentenceListDto();
        resSentenceListDto.setResSentenceDtoList(resSentenceDtos);

        JSONObject reqObject = new JSONObject(reqCheckListDto);
        JSONArray reqArray = reqObject.getJSONArray("reqCheckDtoList");

        JSONObject answerObject = new JSONObject(resSentenceListDto);
        JSONArray answerArray = answerObject.getJSONArray("resSentenceDtoList");

        ResCheckListDto resCheckListDto = new ResCheckListDto();
        Integer score = 0;

        for (int i = 0; i < 10; i++) {
            String reqSentence = reqArray.getJSONObject(i).getString("sentence");
            String answerSentence = answerArray.getJSONObject(i).getString("sentence");

            ResCheckDto resCheckDto = new ResCheckDto();
            resCheckDto.setSentence(reqSentence);

            if (reqSentence.equals(answerSentence)) {
                score += 10;
                resCheckDto.setMatch(true);
            } else {
                resCheckDto.setMatch(false);
                WrongAnswer wrongAnswer = WrongAnswer.from(userId, sentenceTypes, levelTypes, numTypes, i + 1, reqSentence, answerSentence);
                wrongAnswerRepository.save(wrongAnswer);
            }
            resCheckListDto.addCheckDto(resCheckDto);

        }
        resCheckListDto.setScore(score);

        return resCheckListDto;
    }

    @Override
    public ResWrongDto wrongSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, Long userId, Integer sentenceNum) {
        WrongAnswer wrongAnswer = wrongAnswerRepository.findBySentenceTypesAndLevelTypesAndNumTypesAndUserIdAndSentenceNum(sentenceTypes, levelTypes, numTypes, userId, sentenceNum).orElseThrow(WrongAnswerNotFoundException::new);
        return ResWrongDto.from(wrongAnswer);
    }
}
