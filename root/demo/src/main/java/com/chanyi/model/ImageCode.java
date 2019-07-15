package com.chanyi.model;


import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/** */

public class ImageCode {

  /** */
  private BufferedImage  image;

  /**
   *
   */
  private String code;

  /**
   *
   */
  private LocalDateTime expireTime;

  public  ImageCode(BufferedImage image,String code,int expireSeconds){
    this.image  = image;
    this.code = code;
    this.expireTime = LocalDateTime.now().plusSeconds(expireSeconds);

  }

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public LocalDateTime getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(LocalDateTime expireTime) {
    this.expireTime = expireTime;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ImageCode{");
    sb.append("image=").append(image);
    sb.append(", code='").append(code).append('\'');
    sb.append(", expireTime=").append(expireTime);
    sb.append('}');
    return sb.toString();
  }
}
