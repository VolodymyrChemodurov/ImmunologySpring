package com.immunology.logic.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.utils.RoleUtils;
import com.immunology.logic.utils.UserUtils;
import com.immunology.logic.utils.enums.FormType;
import com.immunology.model.Survey;
import com.immunology.model.Syndrome;
import com.immunology.model.ui.SurveyForm;
import com.immunology.model.ui.elements.Element;
import com.immunology.model.ui.elements.impl.Panel;
import com.immunology.model.ui.elements.impl.TextBox;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private CrudDao dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		
		Syndrome syndrome = new Syndrome();
		List<Survey> surveys = new ArrayList<Survey>();
		Survey survey = new Survey();
		
		SurveyForm clinicalManifestationsForm = new SurveyForm();
		clinicalManifestationsForm.setFormType(FormType.CLINICAL_MANIFESTATIONS_FORM);
		SurveyForm complaintsForm = new SurveyForm();
		complaintsForm.setFormType(FormType.COMPLAINTS_FORM);
		List<Panel> panels = new ArrayList<Panel>();
		Panel panel = new Panel();
		Set<Element> elements = new HashSet<Element>();
		TextBox tb = new TextBox();
		tb.setMultiplier(2.0);
		elements.add(tb);
		panel.setElements(elements);
		panels.add(panel);
		clinicalManifestationsForm.setPanels(panels);
		complaintsForm.setPanels(panels);
		survey.getForms().add(complaintsForm);
		survey.getForms().add(clinicalManifestationsForm);
		
		surveys.add(survey);
		syndrome.setSurveys(surveys);
		
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = mapper.writeValueAsString(syndrome);
			LOG.info(result);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return login(request, response);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		User user = UserUtils.getCurrentUser();
		if(RoleUtils.isAdmin(user)) {
			LOG.info("Redirecting to admin");
			return "redirect:/admin";
		} else if(RoleUtils.isUser(user)) {
			LOG.info("Redirecting to user cabinet");
			return "redirect:/cabinet";
		}
		return "login";
	}
	
}