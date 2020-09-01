package com.yutori.server.domain;

import com.yutori.server.dto.LevelTypes;
import com.yutori.server.dto.NumTypes;
import com.yutori.server.dto.ReqCheckSentenceDto;
import com.yutori.server.dto.SentenceTypes;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class ExamRecord {

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

    private Integer score;

    private LocalDateTime time;

    public static ExamRecord from(ReqCheckSentenceDto reqCheckListDto, Integer score) {
        ExamRecord examRecord = new ExamRecord();
        examRecord.userId = reqCheckListDto.getUserId();
        examRecord.sentenceTypes = reqCheckListDto.getSentenceTypes();
        examRecord.levelTypes = reqCheckListDto.getLevelTypes();
        examRecord.numTypes = reqCheckListDto.getNumTypes();
        examRecord.score = score;
        examRecord.time = LocalDateTime.now();
        return examRecord;
    }

}
