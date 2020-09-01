package com.yutori.server.repository;

import com.yutori.server.domain.ExamRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRecordRepository extends JpaRepository<ExamRecord, Long> {
    List<ExamRecord> findAllByUserId(Long userId);
}
