package com.example.gb.controller;

import com.example.gb.model.Router;
import com.example.gb.model.po.ApiAdmin;
import com.example.gb.service.ApiAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiAdminController {

    private final ApiAdminService apiAdminService;
    @Autowired
    public ApiAdminController(ApiAdminService apiAdminService){
        this.apiAdminService = apiAdminService;
    }

    @GetMapping(Router.ApiAdmin.API_ADMIN)
    public List<ApiAdmin> getApiAdmin(@RequestBody ApiAdmin apiAdmin){
        return null;
    }

    @PostMapping(Router.ApiAdmin.API_ADMIN)
    public Boolean insertApiAdmin(@RequestBody ApiAdmin apiAdmin){
        return null;
    }
    @PutMapping(Router.ApiAdmin.API_ADMIN)
    public ApiAdmin updateApiAdmin(@RequestBody ApiAdmin apiAdmin){
        return null;
    }

    @DeleteMapping(Router.ApiAdmin.API_ADMIN)
    public Boolean deleteApiAdmin(int id){
        return null;
    }
}
