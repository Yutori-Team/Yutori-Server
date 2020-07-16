package com.yutori.server.repository;

import com.yutori.server.domain.Sentence;
import com.yutori.server.dto.LevelTypes;
import com.yutori.server.dto.NumTypes;
import com.yutori.server.dto.SentenceTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {
    List<Sentence> findAllBySentenceTypesAndLevelTypesAndNumTypes(SentenceTypes sentenceType, LevelTypes levelTypes, NumTypes numTypes);
}
