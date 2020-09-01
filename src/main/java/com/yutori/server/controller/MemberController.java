package com.yutori.server.controller;

import com.yutori.server.dto.ReqLoginDto;
import com.yutori.server.dto.ReqSignupDto;
import com.yutori.server.dto.ResLoginDto;
import com.yutori.server.service.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ApiOperation("회원을 생성합니다.")
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody ReqSignupDto reqSignupDto) {
        memberService.signup(reqSignupDto);
        return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
    }

    @ApiOperation("로그인하여 토큰을 발급받습니다.")
    @PostMapping("/login")
    public ResponseEntity<ResLoginDto> login(@RequestBody ReqLoginDto reqLoginDto) {
        return new ResponseEntity<>(memberService.login(reqLoginDto), HttpStatus.OK);
    }

    @ApiOperation("아이디를 중복체크합니다.")
    @GetMapping("/checkId")
    public ResponseEntity<String> checkId(@RequestParam String id) {
        memberService.checkId(id);
        return new ResponseEntity<>("id check success", HttpStatus.OK);
    }

}