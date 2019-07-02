package com.chanyi.authention;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Resource
	private DataSource dataSource;
	/**
	 * 配置是内存存储还是数据库存储
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//数据库存储
//		auth.userDetailsService(userDetailsService)
		//写入用户信息
//		 auth.inMemoryAuthentication()
         // 在内存中创建用户并为密码加密
		 //加密不可行
//         .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
//         .and()
//         .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
         //不加密才可以
//         .withUser("admin").password("123456").roles("ADMIN");
		 
		 
		 //通过userDetails实现数据表的查询
//		 auth.authenticationProvider(authenticationProvider());
//		auth
//        .jdbcAuthentication()
//        .usersByUsernameQuery("select * from user where account = ? ")//配置UserDetails查询语句
//        .authoritiesByUsernameQuery("select * from user where account = ? ")//配置用户直接Authorities查询语句
//        .groupAuthoritiesByUsername("select * from user where account = ? ")//配置用户所属组Authorities查询语句
////        .passwordEncoder(passwordEncoder())//启用密码加密功能
//        .dataSource(dataSource);
		
		auth.userDetailsService(myUserDetailsService);
		auth.authenticationProvider(authenticationProvider());
		 
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
////		web.ignoring().antMatchers("/resources/**")
////		.antMatchers("/test/test"); //拦截忽略
//	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/signup", "/about").permitAll() // #4
				.antMatchers("/admin/**").hasRole("ADMIN") // “/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
				.anyRequest().authenticated() // #7
				.and().formLogin()// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”。permitAll()是指用户可以访问formLogin()相关的任何URL
				.loginPage("/login/login")//  注明了登陆页面，意味着用GET访问”/login/login”时，显示登陆页面(自定义页面)
				.permitAll(); // #5
//		http .csrf().disable();
		//安全头的配置
		 http.headers()
		 	.contentTypeOptions();
		 http.headers()
             .xssProtection();
		 http.headers()
             .cacheControl();
		 http.headers()
             .httpStrictTransportSecurity();
		 http.headers()
             .frameOptions();
	}
	
}