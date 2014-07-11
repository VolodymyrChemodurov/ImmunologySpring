package com.immunology.logic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.logic.service.FormServive;
import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.model.ui.Element;
import com.immunology.model.ui.Form;
import com.immunology.model.ui.MedicalCardForm;
import com.immunology.model.ui.elements.Panel;

@Controller
@RequestMapping(value = "/cabinet/patient/form")
public class FormController {
	private static final Logger LOG = LoggerFactory.getLogger(FormController.class);

	@Autowired
	private FormServive formServive;
	@Autowired
	private MedicalCardFormService medicalCardFormService;

	@Autowired
	private MedicalCardFormService medicalCardService;

	@RequestMapping(value = "/medical_card/{id}", method = RequestMethod.GET)
	public @ResponseBody MedicalCardForm getMedicalForm(@PathVariable("id") long id) throws JsonProcessingException {
		MedicalCardForm form = medicalCardService.getById(id);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(form);
		LOG.info(result);
		medicalCardFormService.updateMedicalCardTemplate(form);
		return form;
	}

	@RequestMapping(value = "/getForm", method = RequestMethod.POST)
	public @ResponseBody
	Form addNewWorker(@RequestBody MedicalCardForm jsonForm) {

		LOG.info(jsonForm.toString());
		for (Panel panel : jsonForm.getPanels()) {
			panel.setForm(jsonForm);
			for (Element element : panel.getElements()) {
				element.setPanel(panel);
				if(element.getClass() == Panel.class){
					Panel subPanel = (Panel)element;
					for (Element subElement :subPanel.getElements() ) {
						subElement.setPanel(subPanel);
					}
				}
			}
			
		}
		LOG.info("Update  like Form "+ formServive.updateForm(jsonForm));
		return jsonForm;

	}

}