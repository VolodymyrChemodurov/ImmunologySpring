package com.immunology.logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.ui.MedicalCardForm;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private MedicalCardFormService medicalCardFormService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String admin(Model model) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
		return "admin/main";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView getUsersManagmentPage(ModelAndView model) {
		model.addObject("users", userService.getAllUsers());
		model.setViewName("admin/components/users");
		return model;
	}
	@RequestMapping(value = "/medcard", method = RequestMethod.GET)
	public ModelAndView getMedicalCardPage(ModelAndView model) {
		model.setViewName("admin/components/medcard");
		return model;
	}
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public void createUser(com.immunology.model.User user) {
		userService.createUser(user);
	}
	///ToDo:  Shoulde be change to get Templates
	@RequestMapping(value = "/medical_card", method = RequestMethod.GET)
	public @ResponseBody MedicalCardForm getMedicalForm() throws JsonProcessingException {
		MedicalCardForm form = medicalCardFormService.getById(1L);
		return form;
	}
	
}
