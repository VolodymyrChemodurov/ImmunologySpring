package com.immunology.logic.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.UserDao;
import com.immunology.model.Role;
import com.immunology.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	public User findByLogin(String login) {
		User user = new User();
		user.setLogin(login);
		user.setPassword("1111");
		Set<Role> roles = new HashSet<Role>();
		roles.add(new Role().setRoleName("ROLE_ADMIN"));
		user.setRoles(roles);
		return user;
	}

}
