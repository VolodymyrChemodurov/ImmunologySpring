package com.immunology.logic.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		LOG.info(encoder.encode("1111"));
		return "login";
	}
	
}
