package com.yutori.server.repository;

import com.yutori.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserId(String userId);
    Optional<Member> findByUserIdAndUserPw(String userId, String userPw);
}

