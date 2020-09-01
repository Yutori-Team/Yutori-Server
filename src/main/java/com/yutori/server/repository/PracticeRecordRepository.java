package com.yutori.server.repository;

import com.yutori.server.domain.PracticeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PracticeRecordRepository extends JpaRepository<PracticeRecord, Long> {
    List<PracticeRecord> findAllByUserId(Long userId);
}
