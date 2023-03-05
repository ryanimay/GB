package com.example.gb.controller;

import com.example.gb.model.BaseResult;
import com.example.gb.model.Enum.ResultEnum;
import com.example.gb.model.Router;
import com.example.gb.model.po.Administrator;
import com.example.gb.service.AdministratorService;
import com.example.gb.service.shiro.ShiroRealm;
import jakarta.validation.Valid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 後臺管理員相關接口
 * */
@RestController
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping(Router.Administrator.REGISTER)
    public BaseResult register(@Valid @RequestBody Administrator administrator, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            BaseResult error = BaseResult.error(ResultEnum.INVALID_PARAMS);
            error.setData(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            return error;
        }
        if(administratorService.findByAccount(administrator.getAccount()) != null){
            return BaseResult.error(ResultEnum.NAME_EXISTS);
        }
        BaseResult success = BaseResult.success();
        try{
            administrator = administratorService.insert(administrator);
            success.setData(administrator);
        }catch(Exception e){
            BaseResult error = BaseResult.error(ResultEnum.ERROR);
            error.setData(e.getMessage());
            return error;
        }
        return success;
    }

    @GetMapping(Router.Administrator.LOGIN)
    public BaseResult login(@RequestBody Administrator administrator) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new ShiroRealm());
        SecurityUtils.setSecurityManager(securityManager);


        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken();

        }
        return null;
    }

    @GetMapping(Router.Administrator.ADMINISTRATOR)
    public BaseResult getAdministrator(@RequestBody Administrator administrator) {
        return null;
    }

    @PostMapping(Router.Administrator.ADMINISTRATOR)
    public BaseResult insertAdministrator(@RequestBody Administrator administrator) {
        return null;
    }

    @PutMapping(Router.Administrator.ADMINISTRATOR)
    public BaseResult updateAdministrator(@RequestBody Administrator administrator) {
        return null;
    }

    @DeleteMapping(Router.Administrator.ADMINISTRATOR)
    public BaseResult deleteAdministrator(int id) {
        return null;
    }
}
