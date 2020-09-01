package com.yutori.server.dto;

import lombok.Data;

@Data
public class ReqSavePracticeDto {
    private Long userId;
    private SentenceTypes sentenceTypes;
    private LevelTypes levelTypes;
    private NumTypes numTypes;
}
