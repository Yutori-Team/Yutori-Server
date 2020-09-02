package com.yutori.server.service;

import com.yutori.server.dto.ReqLoginDto;
import com.yutori.server.dto.ReqSignupDto;
import com.yutori.server.dto.ResLoginDto;

public interface MemberService {
    void signup(ReqSignupDto reqSignupDto);
    ResLoginDto login(ReqLoginDto reqLoginDto);
    void checkId(String id);
    void deleteMember(Long userId);
}
