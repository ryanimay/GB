package com.example.gb.service;

import com.example.gb.model.repository.AdministratorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministratorRepository mapper;
}