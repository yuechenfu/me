package com.pib.property.model;

import com.pib.property.model.rest.RestCode;

public enum ProjectRestCode implements RestCode {
    USERNAME_PASSWORD_INCORRECT(10, "Username or password is wrong"),
    OLD_PASSWORD_INCORRECT(11,"Old password error"),
    TOO_MANY_PASSWORD_CHANGE(12,"Change password too frequently"),
    FORGET_CODE_INVALIDATE(13,"Verification code is invalid"),
    USERNAME_REGISTERED(14,"Username has already been registered"),
    USERNAME_REGISTER_SUCEESS(14,"Registration success"),
    SECURITY_CODE_WRONG(21,"invalid code entered"),
    SECURITY_CODE_EXPIRED(22,"This code already expired"),
    USERNAME_SAME(23,"The same username"),
    ACCOUNT_DEL_FORBIDDEN(24,"can not delete account   ")
    ;
    private int code;
    private String message;

    ProjectRestCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }

}
