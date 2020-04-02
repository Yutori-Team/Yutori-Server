package com.yutori.server.dto;

import lombok.Data;

@Data
public class ReqLoginDto {
    private String userId;
    private String userPw;
}

