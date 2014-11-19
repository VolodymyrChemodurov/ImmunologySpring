package com.immunology.logic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.immunology.logic.service.DrugService;
import com.immunology.model.Drug;

public class DrugContoller {

	@Autowired
	private DrugService drugService;

	@RequestMapping(value = "/allDrugs", method = RequestMethod.GET)
	public ModelAndView getAllDrugs(Model model) {

		List<Drug> drugs = new ArrayList<Drug>();
		for (Drug drug : drugService.getAllDrags()) {
			drugs.add(drug);
		}

		return new ModelAndView("user/components/all-patients").addObject(
				"drugs", drugs);
	}
}
