package com.yutori.server.service.impl;

import com.yutori.server.domain.Member;
import com.yutori.server.dto.ReqLoginDto;
import com.yutori.server.dto.ReqSignupDto;
import com.yutori.server.dto.ResLoginDto;
import com.yutori.server.exception.MemberAlreadyExistException;
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
    public void signup(ReqSignupDto reqSignupDto) {
        Member member = Member.from(reqSignupDto);
        memberRepository.save(member);
    }

    @Override
    public ResLoginDto login(ReqLoginDto reqLoginDto) {
        Member member = memberRepository.findByUserIdAndUserPw(reqLoginDto.getUserId(), reqLoginDto.getUserPw()).orElseThrow(MemberNotFoundException::new);

        JwtService.TokenRes token = new JwtService.TokenRes(jwtService.create(member.getId()));

        ResLoginDto resLoginDto = new ResLoginDto();
        resLoginDto.setId(member.getId());
        resLoginDto.setToken(token.getToken());
        return resLoginDto;
    }

    @Override
    public void checkId(String id) {
        if(memberRepository.findByUserId(id).isPresent()){
            throw new MemberAlreadyExistException();
        }
    }


}
