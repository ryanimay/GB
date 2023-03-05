package com.example.gb.model.Enum;

public enum ResultEnum {
    SUCCESS(0, "Success", true),
    ERROR(1, "Somethings wrong", false),
    INVALID_PARAMS(2, "InValid Params", false),
    NAME_EXISTS(3, "Name already exists", false);

    private final Integer code;
    private final String message;
    private final Boolean success;
    ResultEnum(Integer code, String message, Boolean success){
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }
}
