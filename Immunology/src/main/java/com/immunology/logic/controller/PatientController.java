package com.immunology.logic.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.logic.service.PatientService;
import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.Patient;
import com.immunology.model.ui.MedicalCardForm;

@Controller
@RequestMapping(value = "patients")
public class PatientController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	private MedicalCardFormService medicalCardService;
	
	@Autowired
	private SyndromeService syndromeService;

	@RequestMapping(value="/new",  method=RequestMethod.GET )
    public String getNewPatient(Model model ) {
		model.addAttribute("patient",new Patient());
        return "user/components/new-patient";
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public String createNewPatinet(Patient patient, Model model, HttpServletResponse response) {	
		User user = UserUtils.getCurrentUser();
		patient.addUser(userService.getUserByLogin(user.getUsername()));
		MedicalCardForm medicalCard = medicalCardService.getMedicalCardTemplate();
		medicalCard.setCreationDate(new Date());
		patient.setMedicalCard(medicalCard);
		patientService.updatePatient(patient);
		return "redirect:/cabinet";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePatient(Patient patient, Model model, HttpServletResponse response) {	
		patientService.updatePatient(patient);
		return "redirect:/cabinet";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showPatient(ModelMap model, @PathVariable("id") int number){
		User user = UserUtils.getCurrentUser();
		List<String> syndromes = syndromeService.getUserSyndromeTemplateNames(userService.getUserByLogin(user.getUsername()).getId());
		model.addAttribute("patient", patientService.getPatientById(number));
		model.addAttribute("syndromes", syndromes);
		return "user/components/patient-info";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String addPatientToUser(@PathVariable("id") int number, HttpServletResponse response){
	
		User currentUser = UserUtils.getCurrentUser();
		Patient patient = patientService.getPatientById(number);
		com.immunology.model.User user = userService.getUserByLogin(currentUser.getUsername());
		
		user.getPatients().add(patient);
		userService.updateUser(user);
		
		return "redirect:/cabinet";
	}
	
	@RequestMapping(value="/my",  method=RequestMethod.GET)
    public ModelAndView getTest( Model model ) {
		User user = UserUtils.getCurrentUser();
		Set<Patient> myPatients = userService.getUserByLogin(user.getUsername()).getPatients();
        
		return new ModelAndView( "user/components/my-patients" ).addObject("myPatients",myPatients);
    }
	
	@RequestMapping(value="/all",  method=RequestMethod.GET)
    public ModelAndView getAllPatients( Model model ) {
        User currentUser = UserUtils.getCurrentUser();
        boolean isPresent;
        
		Map<Patient, Boolean> patients = new HashMap<Patient, Boolean>();
		for(Patient patient:patientService.getAllPatients()){
			isPresent = false;
			for(com.immunology.model.User user: patient.getUsers()){
				if(user.getLogin().equals(currentUser.getUsername())){
					isPresent = true;
				}
			}
			patients.put(patient, isPresent);
		}
		
		return new ModelAndView("user/components/all-patients").addObject("allPatients",patients);
    }
	@RequestMapping(value="/getAll",  method=RequestMethod.GET)
    public @ResponseBody List<Patient> getAllPatientsInJSON() {
		List<Patient> patients =  patientService.getAllPatients();
		System.out.println(patients);
		return patients;
    }
}