package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.UserDao;
import com.immunology.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	public User findByLogin(String login) {
		TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE user.login = :login", User.class);
		query.setParameter("login", login);
		List<User> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0); 
	}

}
