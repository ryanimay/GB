package com.example.gb.model;

import com.example.gb.model.Enum.ResultEnum;

public class BaseResult {
    private Integer code;
    private String message;
    private Boolean success;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public static BaseResult success(){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ResultEnum.SUCCESS.getCode());
        baseResult.setMessage(ResultEnum.SUCCESS.getMessage());
        baseResult.setSuccess(ResultEnum.SUCCESS.getSuccess());
        return baseResult;
    }

    public static BaseResult error(ResultEnum resultEnum){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(resultEnum.getCode());
        baseResult.setMessage(resultEnum.getMessage());
        baseResult.setSuccess(resultEnum.getSuccess());
        return baseResult;
    }

    public static BaseResult error(ResultEnum resultEnum, Exception e){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(resultEnum.getCode());
        baseResult.setMessage(resultEnum.getMessage());
        baseResult.setSuccess(resultEnum.getSuccess());
        baseResult.setData(e.getMessage());
        return baseResult;
    }
}
