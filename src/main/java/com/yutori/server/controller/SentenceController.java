package com.yutori.server.controller;

import com.yutori.server.dto.*;
import com.yutori.server.service.SentenceService;
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

    private final SentenceService checkService;

    @ApiOperation("")
    @GetMapping("/loadSentence")
    public ResponseEntity<String> loadSentence() {
        checkService.loadSentence();
        return new ResponseEntity<>("db에 문장 저장", HttpStatus.OK);
    }

    @ApiOperation("")
    @GetMapping("/getSentence")
    public ResponseEntity<List<ResSentenceDto>> getSentence(@RequestParam SentenceTypes sentenceTypes,
                                                          @RequestParam LevelTypes levelTypes,
                                                          @RequestParam NumTypes numTypes) {
        return new ResponseEntity<>(checkService.getSentence(sentenceTypes, levelTypes, numTypes), HttpStatus.OK);
    }

    @ApiOperation("")
    @PostMapping("/checkSentence")
    public ResponseEntity<ResCheckListDto> checkSentence(@RequestBody ReqCheckSentenceDto reqCheckListDto) {
        return new ResponseEntity<>(checkService.checkSentence(reqCheckListDto), HttpStatus.OK);
    }

    @ApiOperation("")
    @GetMapping("/wrongSentence")
    public ResponseEntity<ResWrongDto> wrongSentence(@RequestParam Long userId,
                                                     @RequestParam Long sentenceId) {
        return new ResponseEntity<>(checkService.wrongSentence(userId, sentenceId), HttpStatus.OK);
    }

}