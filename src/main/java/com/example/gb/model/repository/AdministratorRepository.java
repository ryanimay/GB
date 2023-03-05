package com.example.gb.model.repository;

import com.example.gb.model.po.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {
    @Query("select a from Administrator a where a.account=?1")
    Administrator findByAccount(String account);
}