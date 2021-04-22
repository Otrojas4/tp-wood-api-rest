package com.springboot.app.tpwood.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.springboot.app.tpwood.dtos.ChangeUserStatusDTO;
import com.springboot.app.tpwood.dtos.LoginDtoResponse;
import com.springboot.app.tpwood.dtos.UserLoginDto;
import com.springboot.app.tpwood.entity.User;
import com.springboot.app.tpwood.repository.IUserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	public User create(User user) throws Exception{
		
		User userInDb = this.userRepo.findByName(user.getName());
		
		if (userInDb != null) {
			throw new Exception("Duplicate");
		}
		
		return userRepo.save(user);
	}

	@Override
	public LoginDtoResponse login(UserLoginDto userLoginDto) throws Exception {
		
		String username = userLoginDto.getName();
		
		User userInDb = this.userRepo.findByName(username);
		
		if (userInDb == null) {
			throw new Exception("Not Exists");
		}
		
		if (userInDb.getStatus().equals("0")) {
			throw new Exception("Disable");
		}
		
		if (userLoginDto.getPassword().equals(userInDb.getPassword())) {
			// generar token
			LoginDtoResponse loginResponse = new LoginDtoResponse();
			
			String token = this.getJWTToken(userInDb);
			
			loginResponse.setToken(token);
			return loginResponse;
		}
		
		return null;
	}

	@Override
	public User findByName(String userName) {
		return this.userRepo.findByName(userName);
	}

	
	private String getJWTToken(User user) {
		String secretKey = "mySecretKey";
		
		List<GrantedAuthority> grantedAuthorities = null;
		
		if (user.getType().equals("ROLE_ADMIN")) {
			grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER, ROLE_ADMIN");
		}
		
		if (user.getType().equals("ROLE_USER")) {
			grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
		}
		
		Integer objectId = user.getId();
		
		String token = Jwts
				.builder()
				.setId(objectId.toString())
				.setSubject(user.getName())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 6000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	@Override
	public List<User> listUsers() {
		return this.userRepo.findAll();
	}

	@Override
	public boolean delete(int id) {
		try {
			this.userRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public User editStatus(ChangeUserStatusDTO changeuserStatusDTO) throws Exception {
		
		User userToUpdate = this.userRepo.findById(changeuserStatusDTO.getId()).orElse(null);
		
		userToUpdate.setStatus(changeuserStatusDTO.getStatus());
		
		return this.userRepo.save(userToUpdate);
	}
	
}
