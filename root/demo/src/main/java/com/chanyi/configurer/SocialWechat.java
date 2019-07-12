package com.chanyi.configurer;

/**
 * 第三方微信配置
 * @author lilei
 *
 */
public class SocialWechat{
	
	private  String appid ;
	
	private  String appSecret ;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppScret(String appSecret) {
		this.appSecret = appSecret;
	}

	@Override
	public String toString() {
		return "SocialWechat [appid=" + appid + ", appSecret=" + appSecret + "]";
	}

	
}