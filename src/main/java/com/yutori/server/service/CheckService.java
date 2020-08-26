package com.yutori.server.service;

import com.yutori.server.dto.*;

public interface CheckService {
    void loadSentence();
    ResSentenceListDto getSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes);
    ResCheckListDto checkSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, Long userId, ReqCheckListDto reqCheckListDto);
    ResWrongDto wrongSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, Long userId, Integer sentenceNum);
}
