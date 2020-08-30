package com.yutori.server.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WrongAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long sentenceId;

    private String mySentence;

    private String answer;

    public static WrongAnswer from(Long userId,
                                   Long sentenceId, String mySentence, String answer) {
        WrongAnswer wrongAnswer = new WrongAnswer();
        wrongAnswer.userId = userId;
        wrongAnswer.sentenceId = sentenceId;
        wrongAnswer.mySentence = mySentence;
        wrongAnswer.answer = answer;
        return wrongAnswer;
    }
}
