package com.yutori.server.service.impl;

import com.yutori.server.domain.ExamRecord;
import com.yutori.server.domain.Member;
import com.yutori.server.domain.PracticeRecord;
import com.yutori.server.dto.ReqUpdateProfileDto;
import com.yutori.server.dto.ResProfileDto;
import com.yutori.server.exception.MemberNotFoundException;
import com.yutori.server.repository.ExamRecordRepository;
import com.yutori.server.repository.MemberRepository;
import com.yutori.server.repository.PracticeRecordRepository;
import com.yutori.server.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

    private final MemberRepository memberRepository;
    private final ExamRecordRepository examRecordRepository;
    private final PracticeRecordRepository practiceRecordRepository;

    @Override
    public ResProfileDto getProfile(Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(MemberNotFoundException::new);

        ResProfileDto resProfileDto = new ResProfileDto();
        resProfileDto.setUserId(member.getUserId());
        resProfileDto.setName(member.getName());
        return resProfileDto;
    }

    @Override
    public void updateProfile(ReqUpdateProfileDto reqUpdateProfileDto) {
        Member member = memberRepository.findById(reqUpdateProfileDto.getId()).orElseThrow(MemberNotFoundException::new);
        member.setName(reqUpdateProfileDto.getName());
        member.setUserPw(reqUpdateProfileDto.getUserPw());
        memberRepository.save(member);
    }

    @Override
    public List<ExamRecord> getExamRecord(Long userId) {
        List<ExamRecord> examRecordList = examRecordRepository.findAllByUserId(userId);
        return examRecordList;
    }

    @Override
    public List<PracticeRecord> getPracticeRecord(Long userId) {
        List<PracticeRecord> practiceRecordList= practiceRecordRepository.findAllByUserId(userId);
        return practiceRecordList;
    }

}
