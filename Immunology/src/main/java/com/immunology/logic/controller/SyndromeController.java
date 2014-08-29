package com.immunology.logic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.Syndrome;

@Controller
@RequestMapping(value = "/syndromes")
public class SyndromeController {

	private static final Logger LOG = LoggerFactory.getLogger(SyndromeController.class);
	
	@Autowired
	private SyndromeService syndromeService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Syndrome> getUserSyndromes() {
		User user = UserUtils.getCurrentUser();
		return syndromeService.getUserSyndromeTemplates(userService.getUserByLogin(user.getUsername()).getId());
	}
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public @ResponseBody List<String> getPatientSyndromes(@PathVariable("id") Long id) {
		LOG.info("getPatientSyndromes");
		return syndromeService.getPatientSyndromeNames(id);
	}
	
	@RequestMapping(value = "/patient/{id}/{name}", method = RequestMethod.GET)
	public @ResponseBody Syndrome getPatientSyndrome(@PathVariable("id") Long id, 
			@PathVariable("name") String syndromeName) {
		
		LOG.info("getPatientSyndrome");
		return syndromeService.getPatientSyndrome(id, syndromeName);
	}
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.POST)
	public @ResponseBody Boolean savePatientSyndrome(@PathVariable("id") Long id) {
		LOG.info("savePatientSyndrome");
		return true;
	}
}
