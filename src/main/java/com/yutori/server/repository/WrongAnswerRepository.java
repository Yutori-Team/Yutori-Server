package com.yutori.server.repository;

import com.yutori.server.domain.WrongAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WrongAnswerRepository extends JpaRepository<WrongAnswer, Long> {
    Optional<WrongAnswer> findByUserIdAndSentenceId(Long userId, Long sentenceId);

}
