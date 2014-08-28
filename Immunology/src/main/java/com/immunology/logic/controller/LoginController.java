package com.immunology.logic.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.immunology.logic.service.FormServive;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private FormServive test;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
}