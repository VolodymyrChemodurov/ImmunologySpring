package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.User;


public interface UserService {

	User createUser(User user);
	
	User updateUser(User user);
	
	List<User> getAllUsers();
}
