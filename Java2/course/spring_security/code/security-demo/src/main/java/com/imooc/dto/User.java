/**
 * 
 */
package com.imooc.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validater.MyConstraint;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Administrator
 *
 */
public class User {
	
	public interface UserSimpleView{};
	public interface UserDetailView extends UserSimpleView{};

	public String getUsername() {
		return username;
	}

	@JsonView(UserSimpleView.class)
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@MyConstraint(message = "这是一个测试")
	@ApiModelProperty(value = "用户名")
	private String username;
	
	@ApiModelProperty(value = "用户密码")
	@NotBlank(message = "密码不能为空")
	private String password;
	
	private String id;
	
	@Past(message = "生日必须是过去的时间")
	private Date birthday;

	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
