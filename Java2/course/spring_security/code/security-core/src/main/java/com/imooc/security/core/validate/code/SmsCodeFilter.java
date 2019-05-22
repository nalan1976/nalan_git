/**
 * 
 */
package com.imooc.security.core.validate.code;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import com.imooc.security.core.properties.SecurityProperties;

/**
 * @author Administrator
 *
 */
public class SmsCodeFilter extends OncePerRequestFilter implements InitializingBean{
//	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
//	@Autowired
	private SecurityProperties securityProperties;
	
	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return authenticationFailureHandler;
	}

	public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationFailureHandler = authenticationFailureHandler;
	}

	public SessionStrategy getSessionStrategy() {
		return sessionStrategy;
	}

	public void setSessionStrategy(SessionStrategy sessionStrategy) {
		this.sessionStrategy = sessionStrategy;
	}

	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	private Set<String> urls = new HashSet<>();
	
	private AntPathMatcher pathMatcher = new AntPathMatcher();

	public Set<String> getUrls() {
		return urls;
	}

	@Override
	public void afterPropertiesSet() throws ServletException {
		// TODO Auto-generated method stub
		super.afterPropertiesSet();
		
		String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(securityProperties.getCode().getSms().getUrl(), ",");
		for(String url : configUrls){
			urls.add(url);
		}
		urls.add("/authentication/mobile");
	}

	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}

	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean action = false;
		for(String url : urls) {
			if(pathMatcher.match(url, request.getRequestURI())) {
				action = true;
			}
		}
		
		/*
		 * if (StringUtils.equals("/authentication/form", request.getRequestURI()) &&
		 * StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
		 */
		if(action) {
			try {
				validate(new ServletWebRequest(request));
			}catch(ValidateCodeException e) {
				authenticationFailureHandler.onAuthenticationFailure(request, response, e);
				return;
			}
		}
		filterChain.doFilter(request, response);

	}

	private void validate(ServletWebRequest servletWebRequest) {
		// TODO Auto-generated method stub
		ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(servletWebRequest, ValidateCodeController.SESSION_SMS);
        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(),
                    "smsCode");
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码的值失败");
        }
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("smsCode:验证码的值不能为空");
        }
        if (codeInSession == null) {
            throw new ValidateCodeException("smsCode:验证码不存在");
        }
        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(servletWebRequest,ValidateCodeController.SESSION_SMS);
            throw new ValidateCodeException("smsCode: 验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("smsCode:验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest,ValidateCodeController.SESSION_SMS);
	}

}
