package com.immunology.logic.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.immunology.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {

	private static final String GET_BY_LOGIN = "SELECT user FROM User user WHERE user.login = :login";
	private static final String LOGIN = "login";

	@Mock
	private EntityManager em;
	
	@Mock
	private TypedQuery<User> query;
	
	@InjectMocks
	private UserDaoImpl userDaoImpl;
	
	private List<User> queryResultList;
	
	@Before
	public void setUp() {
		queryResultList = new ArrayList<User>();
		when(query.getResultList()).thenReturn(queryResultList);
	}
	
	@Test
	public void testFindByLogin_IfUserExists_ReturnUser() {
		User user = createUser(LOGIN); 
		queryResultList.add(user);
		
		when(em.createQuery(GET_BY_LOGIN, User.class)).thenReturn(query);
		when(query.setParameter(LOGIN, LOGIN)).thenReturn(query);
		
		assertEquals(user, userDaoImpl.findByLogin(LOGIN));
	}
	
	@Test
	public void testFindByLogin_IfUserNotFound_ReturnNull() {
		when(em.createQuery(GET_BY_LOGIN, User.class)).thenReturn(query);
		when(query.setParameter(LOGIN, LOGIN)).thenReturn(query);
		
		assertNull(userDaoImpl.findByLogin(LOGIN));
	}

	private User createUser(String login) {
		User user = new User();
		return user.setLogin(login);
	}
}
