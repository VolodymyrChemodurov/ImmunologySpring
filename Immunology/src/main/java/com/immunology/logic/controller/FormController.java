package com.immunology.logic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.FormServive;
import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.model.ui.Form;
import com.immunology.model.ui.MedicalCardForm;

@Controller
@RequestMapping(value = "/cabinet/patient/form")
public class FormController {
	private static final Logger LOG = LoggerFactory
			.getLogger(FormController.class);

	@Autowired
	private FormServive formServive;
	@Autowired
	private MedicalCardFormService medicalCardFormService;

	@Autowired
	private MedicalCardFormService medicalCardService;

	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public @ResponseBody
	MedicalCardForm getFirstForm(Model model) {
		MedicalCardForm form = medicalCardService.getById(1);
		LOG.info(form.toString());
		return form;
	}

	@RequestMapping(value = "/getForm", method = RequestMethod.POST)
	public @ResponseBody
	Form addNewWorker(@RequestBody MedicalCardForm jsonForm) {

		LOG.info(jsonForm.toString());
		//LOG.info(((MedicalCardForm)jsonForm).getAdditionInfo() );
		//formServive.updateForm(jsonForm);
		LOG.info("update " + medicalCardFormService.updateMedicalCardForm(jsonForm));
		return jsonForm;

	}

}