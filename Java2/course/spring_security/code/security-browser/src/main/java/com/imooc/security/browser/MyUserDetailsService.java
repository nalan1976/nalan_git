/**
 * 
 */
package com.imooc.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
	//此处可以注入数据库对象

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//此处可以利用注入的对象，查找用户名对应的信息
		logger.info("登录用户名" + username);
		//根据查找到的用户信息判断用户是否被冻结
		String string = passwordEncoder.encode("123456");
		logger.info("数据库密码是：" + string);
		//返回不一定要用SpringSecurity实现的这个User类，可以自己定义类只要实现UserDetials接口即可
		return new User(username, string
				, true, true, true, true
				, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
