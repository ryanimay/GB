package com.example.gb.model.repository;

import com.example.gb.model.po.TransRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransRecordRepository extends JpaRepository<TransRecord,String> {
}