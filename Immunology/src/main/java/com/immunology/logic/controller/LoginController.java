package com.immunology.logic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.utils.RoleUtils;
import com.immunology.logic.utils.UserUtils;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private CrudDao dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return login(request, response);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		User user = UserUtils.getCurrentUser();
		if(RoleUtils.isAdmin(user)) {
			LOG.info("Redirecting to admin");
			return "redirect:/admin";
		} else if(RoleUtils.isUser(user)) {
			LOG.info("Redirecting to user cabinet");
			return "redirect:/cabinet";
		}
		return "login";
	}
	
}