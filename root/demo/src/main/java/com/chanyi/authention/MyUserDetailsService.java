package com.chanyi.authention;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailsService implements UserDetailsService {

	private final static Log logger = LogFactory.getLog(MyUserDetailsService.class);
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//jdbc查询用户信息
		logger.info("进入myUserDetailService");
		//数据表中的查出的数据封装到userDetails中，返回
		return new User(username,"123456",AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}
}