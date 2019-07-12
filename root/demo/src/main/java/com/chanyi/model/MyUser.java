package com.chanyi.model;


import java.util.Date;

/** */

public class MyUser {

  /** */
  private long id;

  /**
   * 应用id
   */
  private long appId;

  /**
   * 性别
   */
  private int gender;

  /**
   * 手机号(唯一)
   */
  private String mobile;

  /**
   * 手机绑定时间
   */
  private Date mobileBindTime;

  /**
   * 邮箱(唯一)
   */
  private String email;

  /**
   * 邮箱绑定时间
   */
  private Date emailBindTime;

  /**
   * 密码
   */
  private String password;

  /**
   * 用户昵称
   */
  private String nickName;

  /**
   * 出生日期
   */
  private Date birthday;

  /**
   * 头像地址
   */
  private String headImageUrl;

  /**
   * 注册时间
   */
  private Date registerDate;

  /**
   * 用户状态(正常/冻结/注销/'封号)
   */
  private int status;

  /** */
  private int enableWebLogin;

  /**
   * 时区
   */
  private String timeZone;

  /**
   * 扩展字段
   */
  private String extParam;

  /** */
  private int isDelete;

  /** */
  private Date createTime;

  /** */
  private Date updateTime;
/**用户账号(唯一且不可修改) */
  private String account;

/** 国际电话区号*/
  private String countryTelephoneCode;

/** 国家域名*/
  private String country;


  public String getAccount() {
  return account;
}

public void setAccount(String account) {
  this.account = account;
}

public String getCountryTelephoneCode() {
  return countryTelephoneCode;
}

public void setCountryTelephoneCode(String countryTelephoneCode) {
  this.countryTelephoneCode = countryTelephoneCode;
}

public String getCountry() {
  return country;
}

public void setCountry(String country) {
  this.country = country;
}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getAppId() {
    return appId;
  }

  public void setAppId(long appId) {
    this.appId = appId;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Date getMobileBindTime() {
    return mobileBindTime;
  }

  public void setMobileBindTime(Date mobileBindTime) {
    this.mobileBindTime = mobileBindTime;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getEmailBindTime() {
    return emailBindTime;
  }

  public void setEmailBindTime(Date emailBindTime) {
    this.emailBindTime = emailBindTime;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getHeadImageUrl() {
    return headImageUrl;
  }

  public void setHeadImageUrl(String headImageUrl) {
    this.headImageUrl = headImageUrl;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getEnableWebLogin() {
    return enableWebLogin;
  }

  public void setEnableWebLogin(int enableWebLogin) {
    this.enableWebLogin = enableWebLogin;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public String getExtParam() {
    return extParam;
  }

  public void setExtParam(String extParam) {
    this.extParam = extParam;
  }

  public int getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(int isDelete) {
    this.isDelete = isDelete;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", appId=" + appId + ", gender=" + gender + ", mobile=" + mobile
        + ", mobileBindTime=" + mobileBindTime + ", email=" + email + ", emailBindTime="
        + emailBindTime + ", password=" + password + ", nickName=" + nickName + ", birthday="
        + birthday + ", headImageUrl=" + headImageUrl + ", registerDate=" + registerDate
        + ", status=" + status + ", enableWebLogin=" + enableWebLogin + ", timeZone=" + timeZone
        + ", extParam=" + extParam + ", isDelete=" + isDelete + ", createTime=" + createTime
        + ", updateTime=" + updateTime + ", account=" + account + ", countryTelephoneCode="
        + countryTelephoneCode + ", country=" + country + "]";
  }

}
