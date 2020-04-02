package com.yutori.server.domain;

import com.yutori.server.dto.ReqSignupDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String userId;

    private String userPw;

    public static Member from(ReqSignupDto reqSignupDto) {
        Member member = new Member();
        member.name = reqSignupDto.getName();
        member.userId = reqSignupDto.getId();
        member.userPw = reqSignupDto.getPw();
        return member;
    }
}
