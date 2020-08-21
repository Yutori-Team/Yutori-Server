package com.yutori.server.repository;

import com.yutori.server.domain.WrongAnswer;
import com.yutori.server.dto.LevelTypes;
import com.yutori.server.dto.NumTypes;
import com.yutori.server.dto.SentenceTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WrongAnswerRepository extends JpaRepository<WrongAnswer, Long> {
    Optional<WrongAnswer> findBySentenceTypesAndLevelTypesAndNumTypesAndUserIdAndSentenceNum(SentenceTypes sentenceTypes, LevelTypes levelTypes, NumTypes numTypes, Long userId, Integer sentenceNum);
}
