package com.chanyi.configurer;

/**
 * 第三方配置类
 * @author lilei
 *
 */
public class CustomSecurityConfigurerSocial{
	
	private  SocialWechat wechat = new SocialWechat();
	
	private  SocialQQ qq = new SocialQQ();

	public SocialWechat getWechat() {
		return wechat;
	}

	public void setWechat(SocialWechat wechat) {
		this.wechat = wechat;
	}

	public SocialQQ getQq() {
		return qq;
	}

	public void setQq(SocialQQ qq) {
		this.qq = qq;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomSecurityConfiguerSocial [wechat=");
		builder.append(wechat);
		builder.append(", qq=");
		builder.append(qq);
		builder.append("]");
		return builder.toString();
	}
	
}