package com.yutori.server.repository;

import com.yutori.server.domain.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {
    List<Sentence> findAllBySentenceTypesAndLevelTypesAndNumTypes(String sentenceType, String levelTypes, String numTypes);

}
