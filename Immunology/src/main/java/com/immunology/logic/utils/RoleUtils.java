package com.immunology.logic.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.immunology.logic.utils.enums.USER_ROLES;

public class RoleUtils {

	public static boolean isAdmin(User user) {
		return isMatch(user, USER_ROLES.ROLE_ADMIN);
	}
	
	public static boolean isUser(User user) {
		return isMatch(user, USER_ROLES.ROLE_USER);
	}
	
	public static boolean isDoctor(User user) {
		return isMatch(user, USER_ROLES.ROLE_DOCTOR);
	}
	
	private static boolean isMatch(User user, USER_ROLES role) {
		boolean isMatch = false;
		for(GrantedAuthority authority: user.getAuthorities()) {
			if(authority.getAuthority().equals(role.getValue())) {
				isMatch = true;
				break;
			}
		}
		return isMatch;
	}
}
