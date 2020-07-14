package com.yutori.server.domain;

import com.yutori.server.dto.LevelTypes;
import com.yutori.server.dto.NumTypes;
import com.yutori.server.dto.SentenceTypes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Sentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SentenceTypes sentenceTypes;

    @Enumerated(value = EnumType.STRING)
    private LevelTypes levelTypes;

    @Enumerated(value = EnumType.STRING)
    private NumTypes numTypes;

    private String text;

    public static Sentence from(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, String text) {
        Sentence sentence = new Sentence();
        sentence.sentenceTypes = sentenceTypes;
        sentence.levelTypes = levelTypes;
        sentence.numTypes = numTypes;
        sentence.text = text;
        return sentence;
    }

}
