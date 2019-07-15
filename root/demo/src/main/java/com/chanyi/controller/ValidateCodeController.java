package com.chanyi.controller;

import com.chanyi.model.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {


	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

	private final  static String SESSION_CODE_IMAGE_CODE = "iamge_code";

	
	@ResponseBody
	@GetMapping("/getImage")
	public String getImage(HttpServletRequest request, HttpServletResponse response)throws IOException{
		ImageCode imageCode = createCode(request);
		sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_CODE_IMAGE_CODE,imageCode);
		boolean jpeg = ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
		return "";
	}

	private ImageCode createCode(HttpServletRequest request) {
		BufferedImage image = new BufferedImage();
		String code = "";
		return new ImageCode(image,code,60);
	}

}