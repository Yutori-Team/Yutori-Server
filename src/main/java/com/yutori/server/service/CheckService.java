package com.yutori.server.service;

import com.yutori.server.dto.LevelTypes;
import com.yutori.server.dto.NumTypes;
import com.yutori.server.dto.ResSentenceListDto;
import com.yutori.server.dto.SentenceTypes;

public interface CheckService {
    ResSentenceListDto getSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes);
    void saveSentence();
}
