package com.springboot.app.tpwood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<User> login(@RequestBody User user) throws Exception {
		
		User userCreated = this.userService.create(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(userCreated);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping()
	public ResponseEntity<List<User>> listUsers() {
		
		List<User> users = this.userService.listUsers();
		
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable int id) {
		
		boolean deleted = this.userService.delete(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
	
}
