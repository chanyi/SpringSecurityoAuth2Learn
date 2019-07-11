package com.chanyi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chanyi.model.JsonResult;


@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
	
	private final static  Log logger = LogFactory.getLog(UserLoginController.class);
	
	//请求的缓存
	private RequestCache requestCache = new HttpSessionRequestCache();
	//ss里的重定向方法的封装
	private RedirectStrategy rediractStrategy = new DefaultRedirectStrategy();
	
	/**
	 * 登录页
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/loginGate")
	public JsonResult loginGate(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//ss的类saveRequest 
		SavedRequest saveRequest = requestCache.getRequest(request, response);
		if(saveRequest !=null){
			//获取引跳转的请求路径
			String target = saveRequest.getRedirectUrl();
			logger.info("target:"+target);
			if(StringUtils.endsWithIgnoreCase(target, ".html")){
				//跳转到登录页，自己定义的或者配置文件里定义的都可以
				rediractStrategy.sendRedirect(request, response, "");
			}
		}
		logger.info("this is user loginGate");
		return new JsonResult(401,"","");
	}
	
	/**
	 * 执行登录操作
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public String login(){
		logger.info("this is user login");
		return "this is user login";
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public String register(){
		logger.info("this is user register");
		return "this is user register";
	}
	
	
}