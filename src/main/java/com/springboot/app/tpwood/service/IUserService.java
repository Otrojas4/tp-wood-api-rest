package com.springboot.app.tpwood.service;

import java.util.List;

import com.springboot.app.tpwood.dtos.ChangeUserStatusDTO;
import com.springboot.app.tpwood.dtos.LoginDtoResponse;
import com.springboot.app.tpwood.dtos.UserLoginDto;
import com.springboot.app.tpwood.entity.User;

public interface IUserService {

	public User create(User user) throws Exception;
	
	public User editStatus(ChangeUserStatusDTO changeuserStatusDTO) throws Exception;
	
	public User findByName(String userName);
	
	public LoginDtoResponse login(UserLoginDto userLoginDto) throws Exception;
	
	public List<User> listUsers();

	public boolean delete(int id);
}
