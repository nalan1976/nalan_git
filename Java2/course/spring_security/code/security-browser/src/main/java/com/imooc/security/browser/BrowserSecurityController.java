/**
 * 
 */
package com.imooc.security.browser;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.security.browser.support.SimpleResponse;
import com.imooc.security.core.properties.SecurityProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 * @author Administrator
 *
 */
@RestController
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class BrowserSecurityController {

	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@RequestMapping("/authentication/require")
	public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		当需要身份认证时，跳转到这里
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest != null){
			String targetUrl = savedRequest.getRedirectUrl();
			logger.info("引发跳转的请求是：" + targetUrl);
			if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
				redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
			}
		}
		
		return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
	}

}
