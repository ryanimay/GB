package com.example.gb.service;

import com.example.gb.model.repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {
    private AdminRepository mapper;
    @Autowired
    public AdminService(AdminRepository mapper){
        this.mapper = mapper;
    }
}