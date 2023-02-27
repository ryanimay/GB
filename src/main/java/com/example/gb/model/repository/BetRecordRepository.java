package com.example.gb.model.repository;

import com.example.gb.model.po.BetRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRecordRepository extends JpaRepository<BetRecord,Integer> {
}