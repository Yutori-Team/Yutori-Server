package com.yutori.server.controller;

import com.yutori.server.dto.*;
import com.yutori.server.service.CheckService;
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
public class CheckController {

    private final CheckService checkService;

    @ApiOperation("")
    @GetMapping("/saveSentence")
    public ResponseEntity<String> saveSentence() {
        checkService.saveSentence();
        return new ResponseEntity<>("db에 문장 저장", HttpStatus.OK);
    }

    @ApiOperation("")
    @GetMapping("/getSentence")
    public ResponseEntity<ResSentenceListDto> getSentence(@RequestParam SentenceTypes sentenceTypes,
                                                          @RequestParam LevelTypes levelTypes,
                                                          @RequestParam NumTypes numTypes) {
        return new ResponseEntity<>(checkService.getSentence(sentenceTypes, levelTypes, numTypes), HttpStatus.OK);
    }

    @ApiOperation("")
    @PostMapping("/checkSentence")
    public ResponseEntity<ResCheckListDto> checkSentence(@RequestParam SentenceTypes sentenceTypes,
                                                         @RequestParam LevelTypes levelTypes,
                                                         @RequestParam NumTypes numTypes,
                                                         @RequestParam Long userId,
                                                         @RequestBody ReqCheckListDto reqCheckListDto) {
        return new ResponseEntity<>(checkService.checkSentence(sentenceTypes, levelTypes, numTypes, userId, reqCheckListDto), HttpStatus.OK);
    }

    @ApiOperation("")
    @GetMapping("/wrongSentence")
    public ResponseEntity<ResWrongDto> wrongSentence(@RequestParam SentenceTypes sentenceTypes,
                                                     @RequestParam LevelTypes levelTypes,
                                                     @RequestParam NumTypes numTypes,
                                                     @RequestParam Long userId,
                                                     @RequestParam Integer sentenceNum) {
        return new ResponseEntity<>(checkService.wrongSentence(sentenceTypes, levelTypes, numTypes, userId, sentenceNum), HttpStatus.OK);
    }

}