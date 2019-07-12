package com.chanyi.model.enums;
public enum JsonResultCode{
	
	success(200,"success"),
	failed(400,"failed"),
	no_auth(401,"no authorition");
	
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private JsonResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}