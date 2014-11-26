package com.immunology.logic.service.impl;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.immunology.logic.dao.CrudDao;
import com.immunology.model.User;
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends TestCase{

	private static final String PASSWORD = "1111";

	@Mock
	private CrudDao crudDao;
	@Mock
	private PasswordEncoder encoder;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setPassword(PASSWORD);

		when(encoder.encode(PASSWORD)).thenReturn(PASSWORD);
		when(crudDao.create(user)).thenReturn(user);
		
		assertEquals(PASSWORD, userServiceImpl.createUser(user).getPassword());
	}

	@Test
	public void testUpdateUser() {
	}

}
