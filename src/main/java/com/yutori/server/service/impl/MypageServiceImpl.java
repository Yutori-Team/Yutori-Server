package com.yutori.server.service.impl;

import com.yutori.server.domain.Member;
import com.yutori.server.dto.ReqUpdateProfileDto;
import com.yutori.server.dto.ResProfileDto;
import com.yutori.server.exception.MemberNotFoundException;
import com.yutori.server.repository.MemberRepository;
import com.yutori.server.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

    private final MemberRepository memberRepository;

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


}
