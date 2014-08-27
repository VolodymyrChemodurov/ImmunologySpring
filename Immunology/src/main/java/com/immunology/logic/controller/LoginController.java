package com.immunology.logic.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.logic.service.FormServive;
import com.immunology.model.Survey;
import com.immunology.model.Syndrome;
import com.immunology.model.User;
import com.immunology.model.ui.AnamnesticDataForm;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private FormServive test;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		ObjectMapper mapper = new ObjectMapper();
		Syndrome syndrome = new Syndrome();
		syndrome.setName("Test syndrome");
		AnamnesticDataForm anFrom = new AnamnesticDataForm();
		anFrom.setName("Anamnestic form");
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		users.add(user);
		syndrome.setUsers(users);
		syndrome.setAnamnesticData(anFrom);
		List<Survey> surveys = new ArrayList<Survey>();
		surveys.add(new Survey());
		syndrome.setSurveys(surveys);
		try {
			String result = mapper.writeValueAsString(syndrome);
			LOG.info(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "login";
	}
	
}
