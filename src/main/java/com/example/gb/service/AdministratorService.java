package com.example.gb.service;

import com.example.gb.model.po.Administrator;
import com.example.gb.model.repository.AdministratorRepository;
import com.example.gb.tool.EncodeTool;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class AdministratorService {
    private final AdministratorRepository administratorRepository;
    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository){
        this.administratorRepository = administratorRepository;
    }

    public Administrator insert(Administrator administrator) {
        Date createTime = new Date();
        administrator.setCreateTime(createTime);
        administrator.setPassword(EncodeTool.md5Encode(administrator.getPassword(), String.valueOf(createTime.getTime())));
        administrator.setSalt(String.valueOf(createTime.getTime()));
        return administratorRepository.save(administrator);
    }

    public Administrator findByAccount(String account){
        return administratorRepository.findByAccount(account);
    }
}