package com.chanyi.authention;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}