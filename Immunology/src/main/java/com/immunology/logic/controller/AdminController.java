package com.immunology.logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.immunology.logic.service.UserService;
import com.immunology.model.User;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String admin() {
		return "/admin/admin";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getUsersManagmentPage(ModelAndView model) {
		
		model.addObject("users", userService.getAllUsers());
		model.setViewName("/admin/user-management");
		return model;
	}
	
	
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public void createUser(User user) {
		userService.createUser(user);
	}
}
