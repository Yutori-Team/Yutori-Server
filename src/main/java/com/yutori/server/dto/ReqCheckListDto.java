package com.yutori.server.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReqCheckListDto {
    private List<ReqCheckDto> reqCheckDtoList;
}
