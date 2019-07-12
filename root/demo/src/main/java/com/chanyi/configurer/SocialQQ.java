package com.chanyi.configurer;

/**
 * 第三方QQ配置
 * @author lilei
 *
 */
public class SocialQQ{
	
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

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	@Override
	public String toString() {
		return "SocialWechat [appid=" + appid + ", appSecret=" + appSecret + "]";
	}

	
}