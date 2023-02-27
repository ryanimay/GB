package com.example.gb.service;

import com.example.gb.model.repository.BetRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BetRecordService {
    @Autowired
    private BetRecordRepository mapper;
}