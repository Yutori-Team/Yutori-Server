package com.yutori.server.service;

import com.yutori.server.dto.*;

public interface CheckService {
    ResSentenceListDto getSentence(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes);
    void saveSentence();
/*
    ReqUserSentenceListDto score(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes);
    void saveScore();
*/

}
