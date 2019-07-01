package com.chanyi.authention;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	public void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user") // #1
//				.password("password").roles("USER").and().withUser("admin") // #2
//				.password("password").roles("ADMIN", "USER");
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
////		web.ignoring().antMatchers("/resources/**")
////		.antMatchers("/test/test"); //拦截忽略
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests().antMatchers("/signup", "/about").permitAll() // #4
////				.antMatchers("/admin/**").hasRole("ADMIN") // “/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
////				.anyRequest().authenticated() // #7
////				.and().formLogin()// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”。permitAll()是指用户可以访问formLogin()相关的任何URL
////				.loginPage("/login")//  注明了登陆页面，意味着用GET访问”/login”时，显示登陆页面
////				.permitAll(); // #5
//	}
}