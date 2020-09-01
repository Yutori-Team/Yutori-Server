package com.yutori.server.controller;

import com.yutori.server.dto.*;
import com.yutori.server.service.SentenceService;
import com.yutori.server.util.auth.Auth;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/check")
@RequiredArgsConstructor
public class SentenceController {

    private final SentenceService sentenceService;

    @GetMapping("/loadSentence")
    public ResponseEntity<String> loadSentence() {
        sentenceService.loadSentence();
        return new ResponseEntity<>("db에 문장 저장", HttpStatus.OK);
    }

    @Auth
    @GetMapping("/getSentence")
    public ResponseEntity<List<ResSentenceDto>> getSentence(@RequestParam SentenceTypes sentenceTypes,
                                                          @RequestParam LevelTypes levelTypes,
                                                          @RequestParam NumTypes numTypes) {
        return new ResponseEntity<>(sentenceService.getSentence(sentenceTypes, levelTypes, numTypes), HttpStatus.OK);
    }

    @Auth
    @PostMapping("/checkSentence")
    public ResponseEntity<ResCheckListDto> checkSentence(@RequestBody ReqCheckSentenceDto reqCheckListDto) {
        return new ResponseEntity<>(sentenceService.checkSentence(reqCheckListDto), HttpStatus.OK);
    }

    @Auth
    @GetMapping("/wrongSentence")
    public ResponseEntity<ResWrongDto> wrongSentence(@RequestParam Long userId,
                                                     @RequestParam Long sentenceId) {
        return new ResponseEntity<>(sentenceService.wrongSentence(userId, sentenceId), HttpStatus.OK);
    }

    @Auth
    @PostMapping("/savePractice")
    public ResponseEntity<String> savePractice(@RequestBody ReqSavePracticeDto reqSavePracticeDto){
        sentenceService.savePractice(reqSavePracticeDto);
        return new ResponseEntity<>("연습 기록 저장", HttpStatus.OK);
    }

}