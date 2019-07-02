package com.chanyi.authention;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
		User user = new User();
		user.setAccount("lilei");
		user.setPassword("123456");
		logger.info("username:"+username);
		if(username == null || ("").equals(username)){
			try {
				throw new Exception("用户名为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(username.equals(user.getAccount())){
			MyUserDetails myUserDetails = new MyUserDetails(user);
			logger.info("details:"+myUserDetails.getPassword());
			logger.info("details:"+myUserDetails.getUsername());
			return myUserDetails;
		}
		return null;
	}
}