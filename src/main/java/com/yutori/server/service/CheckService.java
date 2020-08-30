package com.yutori.server.service;

import com.yutori.server.dto.*;

import java.util.List;

public interface CheckService {
    void loadSentence();
    List<ResSentenceDto> getSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes);
    ResCheckListDto checkSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, Long userId, ReqCheckListDto reqCheckListDto);
    ResWrongDto wrongSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, Long userId, Integer sentenceNum);
}
