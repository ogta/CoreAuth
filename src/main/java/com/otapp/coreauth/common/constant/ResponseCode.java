package com.otapp.coreauth.common.constant;

public enum ResponseCode {
	
	SUCCESS("0000", "Success"), 
	USERNAME_ALREADY_EXIST("1000", "Username already exist!"),
	USER_NOT_FOUND("1001", "User not found!"),
	TOKEN_EXPIRED("2001", "Token expired!"),
	BUSINESS_FAILED_ALGORITHM_NOT_FOUND("9000", "Algorithm not found!");
	
    private final String code;
    private final String description;

    private ResponseCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String Code() {
        return code;
    }
    
    public String Description() {
        return description;
    }
}
