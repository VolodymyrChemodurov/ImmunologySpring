package com.immunology.logic.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class UserUtils {

	public static User getCurrentUser() {
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user != "anonymousUser") {
			return (User) user;
		} else {
			return null;
		}
	}
	
}
