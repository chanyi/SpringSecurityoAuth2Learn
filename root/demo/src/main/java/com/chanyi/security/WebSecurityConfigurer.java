package com.chanyi.security;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.chanyi.configurer.CustomSecurityConfigurer;

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
	
	private final static Log logger = LogFactory.getLog(WebSecurityConfigurer.class);
	
	private CustomSecurityConfigurer CustomSecurityConfigurer = new CustomSecurityConfigurer();

	/**
	 * 配置是内存存储还是数据库存储
	 * 
	 * @param auth
	 * @throws Exception
	 */
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 数据库存储
		// auth.userDetailsService(userDetailsService)
		// 写入用户信息
		// auth.inMemoryAuthentication()
		// 在内存中创建用户并为密码加密
		// 加密不可行
		// .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
		// .and()
		// .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
		// 不加密才可以
		// .withUser("admin").password("123456").roles("ADMIN");

		// 通过userDetails实现数据表的查询
		// auth.authenticationProvider(authenticationProvider());
//		String sql = "select * from user where account = ?";
//		logger.info(sql);
//		 auth
//		 .jdbcAuthentication()
//		 .usersByUsernameQuery(sql)//配置UserDetails查询语句
//		 .authoritiesByUsernameQuery("select * from user where account = ?")//配置用户直接Authorities查询语句
//		 .groupAuthoritiesByUsername("select * from user where account = ?")//配置用户所属组Authorities查询语句
////		 .passwordEncoder(passwordEncoder())//启用密码加密功能
//		 .dataSource(dataSource);

//		auth.userDetailsService(myUserDetailsService);
		// auth.authenticationProvider(authenticationProvider());
//	}

	// @Override
	// public void configure(WebSecurity web) throws Exception {
	//// web.ignoring().antMatchers("/resources/**")
	//// .antMatchers("/test/test"); //拦截忽略
//	 }

	/**
	 * 注入这个bean，系统会自动将表单传来的密码加密，
	 * 所以在密码检查的时候也要加上对应的加密方法
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// 设置默认的加密方式，这个加密方法使用加盐技术，每次加密的密码都不一样
		return new BCryptPasswordEncoder();
	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.httpBasic();默认输入账号密码的验证方式
		http
		.formLogin()// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”。permitAll()是指用户可以访问formLogin()相关的任何URL
		.loginPage("/userLogin/loginPage")
		.loginProcessingUrl("/userLogin/login")//页面中登录执行的接口
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("login",CustomSecurityConfigurer.getWeb().getLoginPage())
		.permitAll()
		.anyRequest().authenticated();
		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/signup", "/about").permitAll() // #4
//				.antMatchers("/admin/**").hasRole("ADMIN") // “/admin/”开头的URL必须要是管理员用户，譬如”admin”用户
//				.anyRequest().authenticated() // #7
//				.and()
//				.formLogin()// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”。permitAll()是指用户可以访问formLogin()相关的任何URL
		// 安全头的配置
		// http.headers()
		// .contentTypeOptions();
		// http.headers()
		// .xssProtection();
		// http.headers()
		// .cacheControl();
		// http.headers()
		// .httpStrictTransportSecurity();
		// http.headers()
		// .frameOptions();
	}

}