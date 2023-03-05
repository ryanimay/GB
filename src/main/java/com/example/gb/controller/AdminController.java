package com.example.gb.controller;

import com.example.gb.model.Router;
import com.example.gb.model.po.Admin;
import com.example.gb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(Router.Admin.ADMIN)
    public List<Admin> getAdmin(@RequestBody Admin admin) {
        return null;
    }

    @PostMapping(Router.Admin.ADMIN)
    public Boolean insertAdmin(@RequestBody Admin admin) {
        return null;
    }

    @PutMapping(Router.Admin.ADMIN)
    public Admin updateAdmin(@RequestBody Admin admin) {
        return null;
    }

    @DeleteMapping(Router.Admin.ADMIN)
    public Boolean deleteAdmin(int id) {
        return null;
    }
}
