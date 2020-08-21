package com.yutori.server.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResCheckListDto {
    private Integer score;
    private List<ResCheckDto> resCheckDtoList = new ArrayList<>();

    public void addCheckDto(ResCheckDto resCheckDto) {
        resCheckDtoList.add(resCheckDto);
    }
}


