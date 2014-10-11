package com.immunology.logic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;

@Controller
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private SyndromeService syndromeService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showPatient(ModelMap model, @PathVariable("id") long userId){
		User user = UserUtils.getCurrentUser();
		com.immunology.model.User selectedUser = userService.findUserById(userId);
		List<String> syndromes = syndromeService.getUserSyndromeTemplateNames(selectedUser.getId());
		List<String> allSyndroms = syndromeService.getSyndromeNames();
		
		for (String string : syndromes) {
			allSyndroms.remove(string);
		}
		model.addAttribute("user", selectedUser);
		model.addAttribute("syndromes", syndromes);
		model.addAttribute("allSyndroms", allSyndroms);
		return "admin/components/user-info";
	}
}
