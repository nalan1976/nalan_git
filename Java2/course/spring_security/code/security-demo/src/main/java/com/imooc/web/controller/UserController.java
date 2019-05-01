/**
 * 
 */
package com.imooc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.imooc.dto.User.UserDetailView;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/me")
	public Object getCurrentUser(/* Authentication authentication */@AuthenticationPrincipal UserDetails user) {
		return /* authentication */user;
	}
	
	
	@ApiOperation(value= "用户创建")
	@PostMapping
	public User create(@Valid @RequestBody User user, BindingResult errors) {
		
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error->System.out.println(error.getDefaultMessage()));
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}

	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors) {
		
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error->System.out.println(error.getDefaultMessage()));
//			errors.getAllErrors().stream().forEach(error->{
//				FieldError fieldError = (FieldError)error;
//				String message = fieldError.getField() + error.getDefaultMessage();
//				System.out.println(message);
//			}
//			);
			
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}	
	
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@GetMapping
//	public List<User> query(@RequestParam(required=false, name="username", defaultValue="tom") String nickname){
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition condition, @PageableDefault(page = 2, size = 17, sort = "username, asc") Pageable pageable){
//		System.out.println(nickname);
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
//	@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
	@GetMapping("/{id:\\d+}")
	@JsonView(UserDetailView.class)
	public User getInfo(@PathVariable String id) {
//		throw new UserNotExistException(id);
//		throw new RuntimeException("user not exist");
		System.out.println("进入getInfo服务");
		User user = new User();
		user.setUsername("tom");
		return user;
	}
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@ApiParam("待删除ID") @PathVariable String id) {
		System.out.println(id);
	}

}
