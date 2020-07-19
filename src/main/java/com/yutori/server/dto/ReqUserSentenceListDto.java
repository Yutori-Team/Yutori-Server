package com.yutori.server.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ReqUserSentenceListDto {
    private ArrayList<ReqUserSentenceDto> reqUserSentenceDtoArrayList;
}
