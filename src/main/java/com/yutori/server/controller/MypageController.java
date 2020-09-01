package com.yutori.server.controller;

import com.yutori.server.dto.ReqUpdateProfileDto;
import com.yutori.server.dto.ResProfileDto;
import com.yutori.server.service.MypageService;
import com.yutori.server.util.auth.Auth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;

    @Auth
    @GetMapping("/getProfile")
    public ResponseEntity<ResProfileDto> getProfile(@RequestParam Long userId) {
        return new ResponseEntity<>(mypageService.getProfile(userId), HttpStatus.OK);
    }

    @Auth
    @PutMapping("/updateProfile")
    public ResponseEntity<String> updateProfile(@RequestBody ReqUpdateProfileDto reqUpdateProfileDto) {
        mypageService.updateProfile(reqUpdateProfileDto);
        return new ResponseEntity<>("프로필 수정 성공", HttpStatus.OK);
    }

}
