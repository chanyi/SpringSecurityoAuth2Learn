package com.chanyi.authention;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class TestController {
	
	@ResponseBody
	@GetMapping("/")
	public void test(){
		
	}
}