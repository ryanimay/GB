package com.example.gb.model.repository;

import com.example.gb.model.po.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api,Integer> {
}