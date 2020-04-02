package com.yutori.server.controller;

import com.yutori.server.dto.ReqLoginDto;
import com.yutori.server.dto.ReqSignupDto;
import com.yutori.server.dto.ResLoginDto;
import com.yutori.server.dto.ResSignupDto;
import com.yutori.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<ResSignupDto> signup(@RequestBody ReqSignupDto reqSignupDto) {
        return new ResponseEntity<>(memberService.signup(reqSignupDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResLoginDto> login(@RequestBody ReqLoginDto reqLoginDto) {
        return new ResponseEntity<>(memberService.login(reqLoginDto), HttpStatus.OK);
    }

}