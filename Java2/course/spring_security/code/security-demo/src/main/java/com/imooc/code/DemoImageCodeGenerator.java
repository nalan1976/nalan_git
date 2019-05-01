/**
 * 
 */
package com.imooc.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.imooc.security.core.validate.code.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;

/**
 * @author Administrator
 *
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

	/* (non-Javadoc)
	 * @see com.imooc.security.core.validate.code.ValidateCodeGenerator#generator(org.springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public ImageCode generator(ServletWebRequest request) {
		// TODO Auto-generated method stub
		System.out.println("更高级的图形验证码生成代码");
		return null;
	}

}
