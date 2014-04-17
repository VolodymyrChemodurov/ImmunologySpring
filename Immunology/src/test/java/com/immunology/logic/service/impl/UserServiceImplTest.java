package com.immunology.logic.service.impl;

import static org.mockito.Mockito.when;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.immunology.logic.dao.CrudDao;
import com.immunology.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends TestCase{

	@Mock
	private CrudDao crudDao;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setPassword("1111");
		
		when(crudDao.create(user)).thenReturn(user);
		
		assertEquals(user.getPassword(), userServiceImpl.createUser(user).getPassword());
	}

	@Test
	public void testUpdateUser() {
	}

}
