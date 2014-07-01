package com.immunology.logic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Controller;

import com.immunology.logic.utils.RoleUtils;
import com.immunology.logic.utils.UserUtils;

@Controller
public class AccessDeniedHandlerImpl implements AccessDeniedHandler{

	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException deniedException) throws IOException, ServletException {
		User user = UserUtils.getCurrentUser();
		if(RoleUtils.isAdmin(user)) {
			response.sendRedirect("/Immunology/admin");
		} else {
			response.sendRedirect("/Immunology/cabinet");
		}
	}

}
