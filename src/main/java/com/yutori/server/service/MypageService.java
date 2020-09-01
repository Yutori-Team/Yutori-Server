package com.yutori.server.service;

import com.yutori.server.dto.ReqUpdateProfileDto;
import com.yutori.server.dto.ResProfileDto;

public interface MypageService {
    ResProfileDto getProfile(Long userId);
    void updateProfile(ReqUpdateProfileDto reqUpdateProfileDto);
}