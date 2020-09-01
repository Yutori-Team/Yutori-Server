package com.yutori.server.service;

import com.yutori.server.domain.ExamRecord;
import com.yutori.server.domain.PracticeRecord;
import com.yutori.server.dto.ReqUpdateProfileDto;
import com.yutori.server.dto.ResProfileDto;

import java.util.List;

public interface MypageService {
    ResProfileDto getProfile(Long userId);
    void updateProfile(ReqUpdateProfileDto reqUpdateProfileDto);
    List<ExamRecord> getExamRecord(Long userId);
    List<PracticeRecord> getPracticeRecord(Long userId);
}