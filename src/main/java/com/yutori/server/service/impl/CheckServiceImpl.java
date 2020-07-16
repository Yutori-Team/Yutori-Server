package com.yutori.server.service.impl;

import com.opencsv.CSVReader;
import com.yutori.server.domain.Sentence;
import com.yutori.server.dto.*;
import com.yutori.server.repository.SentenceRepository;
import com.yutori.server.service.CheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {

    private final SentenceRepository sentenceRepository;

    @Override
    public ResSentenceListDto getSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes) {
        List<ResSentenceDto> resSentenceDtos = sentenceRepository.findAllBySentenceTypesAndLevelTypesAndNumTypes(sentenceTypes, levelTypes, numTypes)
                .stream()
                .map(ResSentenceDto::from)
                .collect(Collectors.toList());

        ResSentenceListDto resSentenceListDto = new ResSentenceListDto();
        resSentenceListDto.setResSentenceDtoList(resSentenceDtos);

        return resSentenceListDto;
    }

    @Override
    public void saveSentence() {
        try {
            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/main/java/com/yutori/server/util/sentence/sentence_list.csv")), "euc-kr"));
            CSVReader reader = new CSVReader(bufferedReader);
            List<String[]> list = reader.readAll();

            for (String[] str : list) {
                str[1] = str[1].replaceAll("[\\s\u0000]+", "");
                str[2] = str[2].replaceAll("[\\s\u0000]+", "");
                str[3] = str[3].replaceAll("[\\s\u0000]+", "");

                SentenceTypes sentenceTypes = SentenceTypes.valueOf(str[1]);
                LevelTypes levelTypes = LevelTypes.valueOf(str[2]);
                NumTypes numTypes = NumTypes.valueOf(str[3]);

                log.info(str[4]);

                Sentence sentence = Sentence.from(sentenceTypes, levelTypes, numTypes, str[4]);
                sentenceRepository.save(sentence);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
