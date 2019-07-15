package com.chanyi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@ResponseBody
	@GetMapping("/test")
	public String test(){
		return "this is test";
	}

	@ResponseBody
	@GetMapping("/getCurrentUser")
	public Object getCurrentUser(Authentication authentication){
		return authentication;
	}

	@ResponseBody
	@GetMapping("/getUserDetails")
	public Object getUserDetails(@AuthenticationPrincipal UserDetails userDetails){
		return userDetails;
	}
	
	public static void main(String[] args){
		System.out.println(new BCryptPasswordEncoder().encode("secret"));
	}
}