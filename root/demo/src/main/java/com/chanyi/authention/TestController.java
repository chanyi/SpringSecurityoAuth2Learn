package com.chanyi.authention;

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
	
	public static void main(String[] args){
		System.out.println(new BCryptPasswordEncoder().encode("secret"));
	}
}