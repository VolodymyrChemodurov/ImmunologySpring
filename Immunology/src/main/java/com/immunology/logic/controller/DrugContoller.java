package com.immunology.logic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.immunology.model.drug.Drug;
import com.immunology.model.drug.DrugSpecies;
import com.immunology.model.drug.DrugType;
import com.immunology.model.ui.EfficacyData;

@Controller
@RequestMapping(value = "/drugs")
public class DrugContoller {

	private static final Logger LOG = LoggerFactory.getLogger(DrugContoller.class);
	
	@Autowired
	private DrugService drugService;

	@RequestMapping(value = "/syndrome/{syndromeName}", method = RequestMethod.GET)
	public @ResponseBody List<Drug> getSyndromeDrugs(@PathVariable String syndromeName) {
		return drugService.getSyndromeDrugs(syndromeName);
	}
	
	@RequestMapping(value = "/type", method = RequestMethod.POST)
	public @ResponseBody Boolean createDrugType(@RequestBody DrugType drugType) {
		return drugService.saveOrUpdate(drugType);
	}
	
	@RequestMapping(value = "/species", method = RequestMethod.POST)
	public @ResponseBody Boolean createDrugSpecies(@RequestBody DrugSpecies drugSpecies) {
		return drugService.saveOrUpdate(drugSpecies);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Boolean save(@RequestBody Drug drug) {
		return drugService.saveOrUpdate(drug);
	}
	
	@RequestMapping(value = "/{drugId}", method = RequestMethod.POST)
	public @ResponseBody Boolean saveOrUpdate(@RequestBody Drug drug) {
		return drugService.saveOrUpdate(drug);
	}
	
	@RequestMapping(value = "/{drugId}", method = RequestMethod.GET)
	public @ResponseBody Drug getDrugSpecies(@PathVariable Long drugId) {
		Drug drug = drugService.getById(drugId);
		drug.setSpeciesName(drug.getSpecies().getName());
		drug.setTypeName(drug.getSpecies().getType().getName());
		return drug;
	}
	
	@RequestMapping(value = "/{drugId}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteDrug(@PathVariable Long drugId) {
		return drugService.deleteDrug(drugId);
	}
	
	@RequestMapping(value = "/getDrugTypes", method = RequestMethod.GET)
	public @ResponseBody List getDrugTypes() {
		return drugService.getDrugsType();
	}
	
	@RequestMapping(value = "/getDrugSpecies", method = RequestMethod.POST)
	public @ResponseBody List getDrugSpecies(Model model, @RequestParam String typeOfDrugs) {
		return drugService.getDrugSpecies(typeOfDrugs);
	}
	
	@RequestMapping(value = "/getDrugNames", method = RequestMethod.POST)
	public @ResponseBody List getDrugNames(Model model, @RequestParam String speciesOfDrugs) {
			return drugService.getDrugNames(speciesOfDrugs);
	}
	
	@RequestMapping(value="/efficiency/{surveyId}", method = RequestMethod.POST)
	public @ResponseBody Boolean saveEfficiencyData(@RequestBody EfficacyData data, @PathVariable Long surveyId) {
		LOG.info(data.toString());
		LOG.info(surveyId.toString());
		drugService.saveEfficiencyData(data, surveyId);
		return true;
	}
	
	@RequestMapping(value = "/efficiency/{surveyId}", method = RequestMethod.GET)
	public @ResponseBody EfficacyData getEfficacyData(@PathVariable Long surveyId) {
		return drugService.getEfficacyDataBySurveyId(surveyId);
	}
}