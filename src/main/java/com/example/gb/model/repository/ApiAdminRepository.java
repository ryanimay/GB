package com.example.gb.model.repository;

import com.example.gb.model.po.ApiAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiAdminRepository extends JpaRepository<ApiAdmin,Integer> {
}