package com.example.gb.model;

public interface Router {
    interface Administrator{
        String ADMINISTRATOR = "/administrator";
        String REGISTER = ADMINISTRATOR + "/register";
        String LOGIN = ADMINISTRATOR + "/login";
        String LOGOUT = ADMINISTRATOR + "/logout";
    };
    interface Admin{
        String ADMIN = "/admin";
    };
    interface Api{
        String API = "/api";
    };
    interface ApiAdmin{
        String API_ADMIN = "/apiAdmin";
    };
    interface BetRecord{
        String BET_RECORD = "/betRecord";
    };
    interface TransRecord{
        String TRANS_RECORD = "/transRecord";
    };
}
