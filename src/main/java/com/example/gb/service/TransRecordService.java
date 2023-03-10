package com.example.gb.service;

import com.example.gb.model.repository.TransRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransRecordService {
    private TransRecordRepository mapper;
    @Autowired
    public TransRecordService(TransRecordRepository mapper){
        this.mapper = mapper;
    }
}