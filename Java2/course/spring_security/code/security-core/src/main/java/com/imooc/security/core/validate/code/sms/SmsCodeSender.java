/**
 * 
 */
package com.imooc.security.core.validate.code.sms;

/**
 * @author Administrator
 *
 */
public interface SmsCodeSender {
	void send(String mobile, String code);
	

}
