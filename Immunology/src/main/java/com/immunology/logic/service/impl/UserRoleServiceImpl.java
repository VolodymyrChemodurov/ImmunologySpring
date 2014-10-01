package com.immunology.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.UserRoleDao;
import com.immunology.logic.service.UserRoleService;
import com.immunology.logic.utils.enums.UserRoles;
import com.immunology.model.Role;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	UserRoleDao userRoleDao;
	
	@Autowired
	CrudDao crudDao;
	

	public Role getRoleByName(UserRoles role) {
		return userRoleDao.findByUserRole(role);
	}

}
