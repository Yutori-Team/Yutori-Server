package com.yutori.server.domain;

import com.yutori.server.dto.*;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class PracticeRecord {

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

    private LocalDateTime time;

    public static PracticeRecord from(ReqSavePracticeDto reqSavePracticeDto) {
        PracticeRecord practiceRecord = new PracticeRecord();
        practiceRecord.userId = reqSavePracticeDto.getUserId();
        practiceRecord.sentenceTypes = reqSavePracticeDto.getSentenceTypes();
        practiceRecord.levelTypes = reqSavePracticeDto.getLevelTypes();
        practiceRecord.numTypes = reqSavePracticeDto.getNumTypes();
        practiceRecord.time = LocalDateTime.now();
        return practiceRecord;
    }

}
