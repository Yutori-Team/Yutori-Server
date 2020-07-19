package com.yutori.server.controller;

import com.yutori.server.dto.*;
import com.yutori.server.service.CheckService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/check")
@RequiredArgsConstructor

@RestController
public class CheckController {

    private final CheckService checkService;

    @ApiOperation("")
    @GetMapping("/getSentence")
    public ResponseEntity<ResSentenceListDto> getSentence(@RequestParam SentenceTypes sentenceTypes,
                                                          @RequestParam LevelTypes levelTypes,
                                                          @RequestParam NumTypes numTypes) {
        return new ResponseEntity<>(checkService.getSentence(sentenceTypes, levelTypes, numTypes), HttpStatus.OK);
    }

    @ApiOperation("")
    @GetMapping("/saveSentence")
    public ResponseEntity<String> saveSentence() {
        checkService.saveSentence();
        return new ResponseEntity<>("db에 문장 저장", HttpStatus.OK);
    }

/*
    @ApiOperation("")
    @GetMapping("/getUserSentence")
    public RequestEntity<ReqUserSentenceListDto> getUserSentence(@RequestParam SentenceTypes sentenceTypes,
                                                                 @RequestParam LevelTypes levelTypes,
                                                                 @RequestParam NumTypes numTypes) {
        return new RequestEntity<>(checkService.getUserSentence(sentenceTypes, levelTypes, numTypes), HttpStatus.OK);

    }


    @ApiOperation("채점합니다.")
    @PostMapping("/score")
    public ResponseEntity<ResSignupDto> score(@RequestParam SentenceTypes sentenceTypes,
                                              @RequestParam LevelTypes levelTypes,
                                              @RequestParam NumTypes numTypes) {
        return new ResponseEntity<>(checkService.signup(reqSignupDto), HttpStatus.OK);
    }

 */
}