package com.chanyi.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.chanyi.model.ImageCode;

/**
 * 校验码生成器
 * @author zhailiang
 *
 */
@Component
public interface ValidateCodeGenerator {

	/**
	 * 生成校验码
	 * @param request
	 * @return
	 */
	ImageCode generate(ServletWebRequest request);
	
}
