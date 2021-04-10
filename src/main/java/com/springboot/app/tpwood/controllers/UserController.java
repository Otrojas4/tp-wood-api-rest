package com.springboot.app.tpwood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.tpwood.dtos.LoginDtoResponse;
import com.springboot.app.tpwood.dtos.UserLoginDto;
import com.springboot.app.tpwood.entity.User;
import com.springboot.app.tpwood.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	

	@PostMapping(value = "/login")
	public ResponseEntity<LoginDtoResponse> login(@RequestBody UserLoginDto userLogin) {
		
		LoginDtoResponse loginDto = this.userService.login(userLogin);		
		
		return ResponseEntity.status(HttpStatus.OK).body(loginDto);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<User> login(@RequestBody User user) {
		
		User userCreated = this.userService.create(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(userCreated);
	}
	
}
