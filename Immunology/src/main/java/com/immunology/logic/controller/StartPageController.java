package com.immunology.logic.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartPageController {

	@RequestMapping(value = "/index")
	public String getIndex() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(isAdmin(user))
			return "redirect:admin";
		else {
			return "redirect:cabinet";
		}
	}
	
	private boolean isAdmin(User user) {
		boolean isAdmin = false;
		for(GrantedAuthority authority: user.getAuthorities()) {
			if(authority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}
		return isAdmin;
	}
}
