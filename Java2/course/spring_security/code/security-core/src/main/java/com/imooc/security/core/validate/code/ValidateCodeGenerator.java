/**
 * 
 */
package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Administrator
 *
 */
public interface ValidateCodeGenerator {
	
	ValidateCode generator(ServletWebRequest request);

}
