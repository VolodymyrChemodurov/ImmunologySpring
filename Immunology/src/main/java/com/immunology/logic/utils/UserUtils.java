package com.immunology.logic.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class UserUtils {

	public static User getCurrentUser() {
		return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
}
