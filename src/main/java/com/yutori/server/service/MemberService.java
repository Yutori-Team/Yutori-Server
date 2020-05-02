package com.yutori.server.service;

import com.yutori.server.dto.ReqLoginDto;
import com.yutori.server.dto.ReqSignupDto;
import com.yutori.server.dto.ResLoginDto;
import com.yutori.server.dto.ResSignupDto;

public interface MemberService {
    ResSignupDto signup(ReqSignupDto reqSignupDto);
    ResLoginDto login(ReqLoginDto reqLoginDto);
    void checkId(String id);
}
