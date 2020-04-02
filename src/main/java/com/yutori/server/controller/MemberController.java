package com.yutori.server.controller;

import com.yutori.server.dto.ReqLoginDto;
import com.yutori.server.model.DefaultRes;
import com.yutori.server.service.AuthService;
import com.yutori.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MemberController {

    private final AuthService authService;

//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody final ReqLoginDto reqLoginDto) {
//        return new ResponseEntity<>(authService.klogin(reqLoginDto), HttpStatus.OK);
//    }
}