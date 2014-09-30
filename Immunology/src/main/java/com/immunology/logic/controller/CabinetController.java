package com.immunology.logic.controller;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.immunology.logic.service.PatientService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.Patient;

@Controller
@RequestMapping(value = "/cabinet")
public class CabinetController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PatientService patientService;

	@RequestMapping(method = RequestMethod.GET)
	public String cabinet(Model model) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
		return "user/main";
	}
	
	@RequestMapping(value="/analytic/charts",  method=RequestMethod.GET)
    public ModelAndView getAnalyticCharts( Model model ) {
		User user = UserUtils.getCurrentUser();
		Set<Patient> myPatients = userService.getUserByLogin(user.getUsername()).getPatients();
        
		return new ModelAndView( "user/components/analytic-charts").addObject("myPatients",myPatients);
    }
	
	@RequestMapping(value="/analytic/block",  method=RequestMethod.GET)
    public ModelAndView getAnalyticBlock( Model model ) {
		return new ModelAndView("user/components/analytic-block");
    }
	
	@RequestMapping(value="/profile",  method=RequestMethod.GET)
    public String getMyProfile(Model model) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
        return "user/components/profile";
    }
	
	@RequestMapping(value="/profile/edit",  method=RequestMethod.POST)
    public String editProfile(com.immunology.model.User editedUser, Model model, HttpServletResponse response) {
		User user = UserUtils.getCurrentUser();
		com.immunology.model.User immunologyUser = userService.getUserByLogin(user.getUsername());
		
		immunologyUser.setFirstName(editedUser.getFirstName());
		immunologyUser.setLastName(editedUser.getLastName());
		immunologyUser.setMiddleName(editedUser.getMiddleName());
		immunologyUser.setLogin(editedUser.getLogin());
		userService.updateUser(immunologyUser);

		return "redirect:/cabinet";
    }
	
}
