package com.yutori.server.dto;

import lombok.Data;

@Data
public class ResCheckDto {
    private String sentence;
    private Boolean match;
}
