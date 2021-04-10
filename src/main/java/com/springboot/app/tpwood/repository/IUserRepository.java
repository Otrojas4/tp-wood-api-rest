package com.springboot.app.tpwood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.tpwood.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	public User findByName(String name);

}
