/**
 * 
 */
package com.imooc.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author Administrator
 *
 */
public class ValidateCode {


	/**
	 * @param code
	 * @param expireTime
	 */
	public ValidateCode(String code, LocalDateTime expireTime) {

		this.code = code;
		this.expireTime = expireTime;
	}
	
	public ValidateCode(String code, int expireIn) {

		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}


	private String code;
	
	private LocalDateTime expireTime;
	
	



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}
	
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}

}
