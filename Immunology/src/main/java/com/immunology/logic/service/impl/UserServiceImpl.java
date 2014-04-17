package com.immunology.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public User createUser(User user) {
		user.setPassword(codePassword(user.getPassword()));
		return crudDao.create(user);
	}

	public User updateUser(User user) {
		user.setPassword(codePassword(user.getPassword()));
		return crudDao.saveOrUpdate(user);
	}

	private String codePassword(String password) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
