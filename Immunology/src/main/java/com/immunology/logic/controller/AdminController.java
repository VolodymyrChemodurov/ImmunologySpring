package com.immunology.logic.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.UserRoleService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.ui.MedicalCardForm;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private MedicalCardFormService medicalCardFormService;
	@Autowired
	private SyndromeService syndromeService;

	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping(method = RequestMethod.GET)
	public String admin(ModelMap model) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user",
				userService.getUserByLogin(user.getUsername()));
		List<String> syndromes = syndromeService.getSyndromeNames();
		model.addAttribute("syndromes", syndromes);
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

	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String getNewUser(Model model) {
		model.addAttribute("user", new com.immunology.model.User());
		return "admin/components/new-user";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createNewPatinet(@RequestParam("user_role") String role,
			com.immunology.model.User user, Model model,
			HttpServletResponse response) {
		userService.createUser(user, role);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/anamnestic", method = RequestMethod.GET)
	public ModelAndView getAnamnestic(ModelAndView model) {
		model.setViewName("admin/components/anamnestic");
		return model;
	}

	// /ToDo: Shoulde be change to get Templates
	@RequestMapping(value = "/medical_card", method = RequestMethod.GET)
	public @ResponseBody MedicalCardForm getMedicalForm()
			throws JsonProcessingException {
		MedicalCardForm form = medicalCardFormService.getMedicalCardTemplate();
		return form;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getMyProfile(Model model) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user",
				userService.getUserByLogin(user.getUsername()));
		return "admin/components/profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public String editProfile(com.immunology.model.User editedUser,
			Model model, HttpServletResponse response) {
		User user = UserUtils.getCurrentUser();
		com.immunology.model.User immunologyUser = userService
				.getUserByLogin(user.getUsername());

		immunologyUser.setFirstName(editedUser.getFirstName());
		immunologyUser.setLastName(editedUser.getLastName());
		immunologyUser.setMiddleName(editedUser.getMiddleName());
		userService.updateUser(immunologyUser);

		return "redirect:/admin";
	}

	@RequestMapping(value = "/change/password", method = RequestMethod.POST)
	public @ResponseBody Boolean changePassword(Model model,
			@RequestParam String password, @RequestParam String oldPassword) {
		User user = UserUtils.getCurrentUser();
		com.immunology.model.User immunologyUser = userService
				.getUserByLogin(user.getUsername());
		boolean match = encoder.matches(oldPassword,
				immunologyUser.getPassword());
		if (match) {
			immunologyUser.setPassword(encoder.encode(password));
			userService.updateUser(immunologyUser);

		}
		return match;
	}
	
	@RequestMapping(value = "/formulas", method = RequestMethod.GET)
	public ModelAndView getFormulas(ModelAndView model) {
		List<String> syndromesNames = syndromeService.getSyndromeNames();
		model.addObject("syndromes", syndromesNames);
		model.setViewName("admin/components/formulas");
		return model;
	}
}
