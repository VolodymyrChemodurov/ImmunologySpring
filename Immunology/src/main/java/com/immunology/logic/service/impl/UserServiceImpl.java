package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.UserDao;
import com.immunology.logic.service.UserService;
import com.immunology.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CrudDao crudDao;
	
	@Autowired
	private PasswordEncoder encoder; 
	
	public User createUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return crudDao.create(user);
	}

	public User updateUser(User user) {
		//user.setPassword(encoder.encode(user.getPassword()));
		return crudDao.saveOrUpdate(user);
	}

	public List<User> getAllUsers() {
		return crudDao.getAll(User.class);
	}

	public User getUserByLogin(String login) {
		return userDao.findByLogin(login);
	}
}
