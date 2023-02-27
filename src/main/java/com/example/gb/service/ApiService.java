package com.example.gb.service;

import com.example.gb.model.repository.ApiRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ApiService {
    private ApiRepository mapper;
    @Autowired
    public ApiService(ApiRepository mapper){
        this.mapper = mapper;
    }
}