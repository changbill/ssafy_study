package com.ssafy.user.model.dao;

import java.util.List;

import com.ssafy.user.model.dto.User;

public interface UserDao {

	List<User> selectAll();

	int insertUser(User user);
	
	User selectOne(String id);
	
}