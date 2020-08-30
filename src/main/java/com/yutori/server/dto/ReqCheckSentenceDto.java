package com.yutori.server.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReqCheckSentenceDto {
    private Long userId;
    private SentenceTypes sentenceTypes;
    private LevelTypes levelTypes;
    private NumTypes numTypes;
    private List<ReqCheckDto> reqCheckDtoList;
}
