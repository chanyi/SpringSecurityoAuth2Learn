package com.chanyi.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.chanyi.model.ImageCode;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {


	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	@Autowired
	private ValidateCodeGenerator validateCodeGenerator;

	private final  static String SESSION_CODE_IMAGE_CODE = "iamge_code";

	
	@ResponseBody
	@GetMapping("/getImage")
	public Object getImage(HttpServletRequest request, HttpServletResponse response)throws IOException{
		ImageCode imageCode = createCode(request,response);
		sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_CODE_IMAGE_CODE,imageCode);
//		boolean jpeg = ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
		return imageCode;
	}

	private ImageCode createCode(HttpServletRequest request, HttpServletResponse response) {
		return validateCodeGenerator.generate(new ServletWebRequest(request,response));
		
	}

}