package com.immunology.logic.service.impl;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.UserRoleDao;
import com.immunology.logic.utils.enums.UserRoles;
import com.immunology.model.Role;
import com.immunology.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends TestCase{

	private static final String PASSWORD = "1111";

	@Mock
	private CrudDao crudDao;
	@Mock
	private PasswordEncoder encoder;
	@Mock
	private UserRoleDao userRoleDao;
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setPassword(PASSWORD);

		Mockito.when(encoder.encode(PASSWORD)).thenReturn(PASSWORD);
		Mockito.when(crudDao.create(user)).thenReturn(user);
		Mockito.when(userRoleDao.findByUserRole(Mockito.any(UserRoles.class))).thenReturn(new Role());
		
		assertEquals(PASSWORD, userServiceImpl.createUser(user, UserRoles.ROLE_USER.getValue()).getPassword());
	}

	@Test
	public void testUpdateUser() {
	}

}
