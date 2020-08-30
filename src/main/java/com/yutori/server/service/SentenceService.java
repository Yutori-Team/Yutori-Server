package com.yutori.server.service;

import com.yutori.server.dto.*;

import java.util.List;

public interface SentenceService {
    void loadSentence();
    List<ResSentenceDto> getSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes);
    ResCheckListDto checkSentence(ReqCheckSentenceDto reqCheckListDto);
    ResWrongDto wrongSentence(Long userId, Long sentenceId);
}
