package com.immunology.logic.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.UserDao;
import com.immunology.logic.dao.UserRoleDao;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.enums.UserRoles;
import com.immunology.model.Role;
import com.immunology.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CrudDao crudDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private PasswordEncoder encoder; 
	
	public User createUser(User user, String role) {
		Set<Role> roles = new HashSet<Role>();
		roles.add(userRoleDao.findByUserRole(UserRoles.valueOf(role)));
		user.setRoles(roles);
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

	public User findUserById(Long id) {
		return crudDao.find(User.class, id);
	}
}
