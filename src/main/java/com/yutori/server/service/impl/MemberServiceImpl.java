package com.yutori.server.service.impl;

import com.yutori.server.domain.Member;
import com.yutori.server.dto.ReqSignupDto;
import com.yutori.server.dto.ResSignupDto;
import com.yutori.server.exception.MemberAlreadyException;
import com.yutori.server.exception.MemberNotFoundException;
import com.yutori.server.repository.MemberRepository;
import com.yutori.server.service.JwtService;
import com.yutori.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    @Override
    public ResSignupDto signup(ReqSignupDto reqSignupDto) {
        if(memberRepository.findByUserId(reqSignupDto.getId()).isPresent()){
            throw new MemberAlreadyException();
        }

        Member member = Member.from(reqSignupDto);
        memberRepository.save(member);

        JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(member.getId()));
        ResSignupDto resSignupDto = new ResSignupDto();
        resSignupDto.setId(member.getId());
        resSignupDto.setToken(token.getToken());
        return resSignupDto;
    }
}
