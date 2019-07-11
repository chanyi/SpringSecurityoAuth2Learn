package com.chanyi.util;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Encrypt{
	
	private final static Log logger = LogFactory.getLog(Encrypt.class);
	/**
	 * 按类型对字符串进行加密并转换成16进制输出
	 * 
	 * @param str
	 *            字符串
	 * @param type
	 *            可加密类型md5, des , sha1
	 * @return 加密后的字符串
	 */
	public static String encode(String str, String type) {
		try {
			MessageDigest alga = MessageDigest.getInstance(type);
			alga.update(str.getBytes());
			byte digesta[] = alga.digest();
			String hex = byte2hex(digesta);
			return hex;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}
	
	/**
	 * 将字节数组转换成16进制字符
	 * 
	 * @param b
	 *            需要转换的字节数组
	 * @return 转换后的16进制字符
	 */
	public static String byte2hex(byte b[]) {
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < b.length; n++) {
			String stmp = Integer.toHexString(b[n] & 0xff);
			if (stmp.length() == 1) {
				sb.append("0");
			}
			sb.append(stmp);
		}

		return sb.toString().toUpperCase();
	}
	
}