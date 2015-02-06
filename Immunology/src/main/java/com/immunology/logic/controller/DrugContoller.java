package com.immunology.logic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.DrugService;
import com.immunology.model.ui.EfficacyData;

@Controller
@RequestMapping(value = "/drugs")
public class DrugContoller {

	private String typeOfDrugs;
	private String speciesOfDrugs;

	@Autowired
	private DrugService drugService;

	
	@RequestMapping(value = "/getDrugSpecies", method = RequestMethod.POST)
	public @ResponseBody List getDrugSpecies(Model model,
			@RequestParam String typeOfDrugs) {
		this.typeOfDrugs= typeOfDrugs;
		return drugService.getDrugSpecies(typeOfDrugs);
	}
	
	@RequestMapping(value = "/getDrugNames", method = RequestMethod.POST)
	public @ResponseBody List getDrugNames(Model model,
			@RequestParam String speciesOfDrugs) {
			this.speciesOfDrugs = speciesOfDrugs.trim();
			return drugService.getDrugNames(speciesOfDrugs);
	}
	
	@RequestMapping(value="/efficiency/{surveyId}", method = RequestMethod.POST)
	public void saveEfficiencyData(@RequestBody EfficacyData data, @PathVariable Long surveyId) {
		//TODO actual saving
	}
}