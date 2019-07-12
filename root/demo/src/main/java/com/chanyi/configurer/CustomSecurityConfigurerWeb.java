package com.chanyi.configurer;

public class CustomSecurityConfigurerWeb{
	
	private  String loginPage = "/login/login";

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	@Override
	public String toString() {
		return "CustomSecurityConfiguerWeb [loginPage=" + loginPage + "]";
	}
	
	
	
}