package com.example.gb.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @RequestMapping("/test")
    public String opValid(){
        return "OK";
    }
}
