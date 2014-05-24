package com.immunology.logic.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.immunology.logic.ImmunologyTestSuite;
import com.immunology.logic.service.PatientService;
import com.immunology.logic.service.UserService;
import com.immunology.model.Patient;
@Transactional
@Controller
@RequestMapping(value = "/cabinet")
public class CabinetController {
	
	private static final Logger LOG = Logger.getLogger(CabinetController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	PatientService patientService;

	@RequestMapping(method = RequestMethod.GET)
	public String cabinet(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
		return "user/main";
	}
	
	@RequestMapping(value="/my-patients",  method=RequestMethod.GET )
    public ModelAndView getMyPatients(Model model) {
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//model.addAttribute("userTest", userService.getUserByLogin(user.getUsername()));
		//ModelAndView myModel = new ModelAndView("user/my-patients");
		//List<Patient> patients = patientService.getAllPatients();
		//model.addAttribute("patients",patients);
		//myModel.addObject("patients",patients);
        return new ModelAndView("user/component/all-patients");
    }
	
	@RequestMapping(value="/patients/my",  method=RequestMethod.GET )
    public ModelAndView getTest( Model model ) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Patient> myPatients = patientService.getMyPatients(userService.getUserByLogin(user.getUsername()));
        
		return new ModelAndView( "user/components/my-patients" ).addObject("myPatients",myPatients);
    }
	
	
	@RequestMapping(value="/patients/all",  method=RequestMethod.GET )
    public ModelAndView getAllPatients( Model model ) {
		
		List<Patient> patients = patientService.getAllPatients();
        
		return new ModelAndView( "user/components/all-patients" ).addObject("allPatients",patients);
    }
	
	@RequestMapping(value="/analitic/charts",  method=RequestMethod.GET )
    public ModelAndView getAnaliticCharts( Model model ) {
       
		return new ModelAndView( "user/components/analitic-charts" );
    }
	@RequestMapping(value="/analitic/block",  method=RequestMethod.GET )
    public ModelAndView getAnaliticBlock( Model model ) {
       
		return new ModelAndView( "user/components/analitic-block" );
    }
	
	// NAVBAR
	@RequestMapping(value="/profile",  method=RequestMethod.GET )
    public String getMyProfile(Model model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
        return "user/components/profile";
    }
	@RequestMapping(value="/profile/edit",  method=RequestMethod.POST )
    public String editProfile(com.immunology.model.User editedUser, Model model, HttpServletResponse response) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		com.immunology.model.User immunologyUser = userService.getUserByLogin(user.getUsername());
		
		immunologyUser.setFirstName(editedUser.getFirstName());
		immunologyUser.setLastName(editedUser.getLastName());
		immunologyUser.setMiddleName(editedUser.getMiddleName());
		immunologyUser.setLogin(editedUser.getLogin());
		
		userService.updateUser(immunologyUser);
		
		try {
			response.sendRedirect("/Immunology/cabinet");
		} catch (IOException e) {
			LOG.error(e);
		}
        return "forward:cabinet";
    }

	
}
