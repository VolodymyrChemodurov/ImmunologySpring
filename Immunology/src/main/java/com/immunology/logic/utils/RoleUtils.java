package com.immunology.logic.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.immunology.logic.utils.enums.UserRoles;

public class RoleUtils {

	public static boolean isAdmin(User user) {
		return isMatch(user, UserRoles.ROLE_ADMIN);
	}
	
	public static boolean isUser(User user) {
		return isMatch(user, UserRoles.ROLE_USER);
	}
	
	public static boolean isDoctor(User user) {
		return isMatch(user, UserRoles.ROLE_DOCTOR);
	}
	
	private static boolean isMatch(User user, UserRoles role) {
		boolean isMatch = false;
		if(user != null) {
			for(GrantedAuthority authority: user.getAuthorities()) {
				if(authority.getAuthority().equals(role.getValue())) {
					isMatch = true;
					break;
				}
			}
		}
		return isMatch;
	}
}
