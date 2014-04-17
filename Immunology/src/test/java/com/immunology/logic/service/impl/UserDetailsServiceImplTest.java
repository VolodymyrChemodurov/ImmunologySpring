package com.immunology.logic.service.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.immunology.logic.dao.UserDao;
import com.immunology.model.Role;
import com.immunology.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest extends TestCase {

	private static final String ROLE_TEST = "ROLE_TEST";
	private static final String PASSWORD = "1111";
	private static final String LOGIN = "login";

	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Test
	public void testLoadUserByUsername_IfUserExists_ReturnUserDetails() {
		User user = createUser(LOGIN, PASSWORD);
		
		when(userDao.findByLogin(LOGIN)).thenReturn(user);
		
		assertEquals(LOGIN, userDetailsServiceImpl.loadUserByUsername(LOGIN).getUsername());
	}

	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUsername_IfUserNotFound_ThrowUsernameNotFoundException() {
		when(userDao.findByLogin(anyString())).thenReturn(null);
		
		userDetailsServiceImpl.loadUserByUsername(LOGIN);
	}
	
	private User createUser(String login, String password) {
		User user = new User();
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setRoleName(ROLE_TEST);
		roles.add(role);
		user.setLogin(login).setPassword(password).setRoles(roles);
		return user;
	}
}
