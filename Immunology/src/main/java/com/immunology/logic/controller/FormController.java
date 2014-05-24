package com.immunology.logic.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.FormServive;
import com.immunology.model.ui.Form;

@Controller
@RequestMapping(value = "/cabinet/patient/form")
public class FormController {

	private static final Logger LOG = Logger.getLogger(FormController.class);

	@Autowired
	private FormServive formServive;

	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public @ResponseBody Form getFirstForm(Model model) {
		Form form = formServive.getFormById(1L);
		LOG.info(form);
		return form;
	}

}
