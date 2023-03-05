package com.example.gb.controller;

import com.example.gb.model.Router;
import com.example.gb.model.po.Api;
import com.example.gb.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(Router.Api.API)
    public List<Api> getApi(@RequestBody Api api) {
        return null;
    }

    @PostMapping(Router.Api.API)
    public Boolean insertApi(@RequestBody Api api) {
        return null;
    }

    @PutMapping(Router.Api.API)
    public Api updateApi(@RequestBody Api api) {
        return null;
    }

    @DeleteMapping(Router.Api.API)
    public Boolean deleteApi(int id) {
        return null;
    }
}
