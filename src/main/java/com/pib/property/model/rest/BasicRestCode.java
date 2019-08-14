package com.pib.property.model.rest;

public enum BasicRestCode implements RestCode{
	SUCCESS(0, "ok"), FAIL(1, "fail"), UNAUTHORIZED(2, "权限不足"), PARAMETER(3, "参数错误")
	; 
	
	private int code;
	private String message;
	BasicRestCode(int code) {
		this.code = code;
	}
	BasicRestCode(int code, String message) {
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
