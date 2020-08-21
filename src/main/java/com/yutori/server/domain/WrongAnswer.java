package com.yutori.server.domain;

import com.yutori.server.dto.LevelTypes;
import com.yutori.server.dto.NumTypes;
import com.yutori.server.dto.SentenceTypes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WrongAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(value = EnumType.STRING)
    private SentenceTypes sentenceTypes;

    @Enumerated(value = EnumType.STRING)
    private LevelTypes levelTypes;

    @Enumerated(value = EnumType.STRING)
    private NumTypes numTypes;

    private Integer sentenceNum;

    private String mySentence;

    private String answer;

    public static WrongAnswer from(Long userId, SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes,
                                   Integer sentenceNum, String mySentence, String answer) {
        WrongAnswer wrongAnswer = new WrongAnswer();
        wrongAnswer.userId = userId;
        wrongAnswer.sentenceTypes = sentenceTypes;
        wrongAnswer.levelTypes = levelTypes;
        wrongAnswer.numTypes = numTypes;
        wrongAnswer.sentenceNum = sentenceNum;
        wrongAnswer.mySentence = mySentence;
        wrongAnswer.answer = answer;
        return wrongAnswer;
    }
}
