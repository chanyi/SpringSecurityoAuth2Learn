package com.chanyi.authention;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.chanyi.dao.Jdbc;
import com.chanyi.util.Encrypt;


@Component
public class MyUserDetailsService implements UserDetailsService {

	private final static Log logger = LogFactory.getLog(MyUserDetailsService.class);
	
	@Autowired
	private Jdbc jdbc;
	
	public BCryptPasswordEncoder passwordEncoder() {
		// 设置默认的加密方式
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//jdbc查询用户信息
		logger.info("进入myUserDetailService");
		//数据表中的查出的数据封装到userDetails中，
//		String sql = "select * from user where account = "+ username;
//		MyUser user = jdbc.query(sql, MyUser.class);
		String password = passwordEncoder().encode("123456");
		logger.info("password:"+password);
		return new User(username,password,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//		return new User(user.getAccount(),Encrypt.encode(user.getPassword(),"MD5"),AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}
}