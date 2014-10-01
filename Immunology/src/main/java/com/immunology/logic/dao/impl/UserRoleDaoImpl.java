package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.UserRoleDao;
import com.immunology.logic.utils.enums.UserRoles;
import com.immunology.model.Role;

@Repository
public class UserRoleDaoImpl implements UserRoleDao{

	@PersistenceContext
	private EntityManager em;
	
	public Role findByUserRole(UserRoles userRole) {
		TypedQuery<Role> query = em.createQuery("SELECT roles FROM Role roles WHERE roles.roleName = :userRole", Role.class);
		query.setParameter("userRole", userRole);
		List<Role> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0); 
	}

}
