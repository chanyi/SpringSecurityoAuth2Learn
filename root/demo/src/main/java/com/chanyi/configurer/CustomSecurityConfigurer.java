package com.chanyi.configurer;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "security.custom")
public class CustomSecurityConfigurer{
	
	private  CustomSecurityConfigurerWeb web = new CustomSecurityConfigurerWeb();
	
	private  CustomSecurityConfigurerSocial social = new CustomSecurityConfigurerSocial();
	
	private String test;
	
	

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public CustomSecurityConfigurerWeb getWeb() {
		return web;
	}

	public void setWeb(CustomSecurityConfigurerWeb web) {
		this.web = web;
	}


	public CustomSecurityConfigurerSocial getSocial() {
		return social;
	}

	public void setSocial(CustomSecurityConfigurerSocial social) {
		this.social = social;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomSecurityConfigurer [web=");
		builder.append(web);
		builder.append(", social=");
		builder.append(social);
		builder.append(", test=");
		builder.append(test);
		builder.append("]");
		return builder.toString();
	}
	
	
}