package com.example.gb.controller;

import com.example.gb.model.BaseResult;
import com.example.gb.model.Enum.ResultEnum;
import com.example.gb.model.Router;
import com.example.gb.model.po.Administrator;
import com.example.gb.service.AdministratorService;
import jakarta.validation.Valid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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

    private final AdministratorService administratorService;
    @Autowired
    public AdministratorController(AdministratorService administratorService){
        this.administratorService = administratorService;
    }

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
            return BaseResult.error(ResultEnum.ERROR, e);
        }
        return success;
    }

    @PostMapping(Router.Administrator.LOGIN)
    public BaseResult login(@RequestBody Administrator administrator) {
        UsernamePasswordToken token = new UsernamePasswordToken(administrator.getAccount(), administrator.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (UnknownAccountException e) {
            return BaseResult.error(ResultEnum.ACCOUNT_NOT_EXISTS, e);
        } catch (IncorrectCredentialsException e) {
            return BaseResult.error(ResultEnum.WRONG_PASSWORD, e);
        }
        return BaseResult.success();
    }

    @PostMapping(Router.Administrator.LOGOUT)
    public BaseResult logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseResult.success();
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
