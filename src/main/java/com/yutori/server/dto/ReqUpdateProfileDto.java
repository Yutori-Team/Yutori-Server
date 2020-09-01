package com.yutori.server.dto;

import lombok.Data;

@Data
public class ReqUpdateProfileDto {
    private Long id;
    private String name;
    private String userPw;
}
