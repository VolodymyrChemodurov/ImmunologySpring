package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.User;


public interface UserService {

	User createUser(User user, String role);
	
	User updateUser(User user);
	
	List<User> getAllUsers();
	
	User getUserByLogin(String login);
	
	User findUserById(Long id);
}
