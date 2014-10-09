package com.immunology.logic.dao;

import com.immunology.model.User;

public interface UserDao {

	User findByLogin(String login);
	
}
