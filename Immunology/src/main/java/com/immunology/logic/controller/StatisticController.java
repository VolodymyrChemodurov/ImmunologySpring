package com.immunology.logic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.DrugService;
import com.immunology.logic.service.StatisticService;
import com.immunology.logic.service.SurveyService;
import com.immunology.logic.utils.UserUtils;

@Controller
@RequestMapping("statistic")
public class StatisticController {

	public static final Logger LOG = LoggerFactory
			.getLogger(StatisticController.class);

	private String nameOfDrugs;
	private long userId;

	@Autowired
	private StatisticService statisticService;

	@Autowired
	private DrugService drugService;
	
	@RequestMapping(value = "/medical_cards/by_years", method = RequestMethod.GET)
	public @ResponseBody List retrieveMedicalCardCreationStatistic() {
		return statisticService.retrieveMedicalCardCreationStatistic();
	}

	@RequestMapping(value = "/syndrome/by_patient", method = RequestMethod.GET)
	public @ResponseBody List retrieveSyndromePatientStatistic() {
		return statisticService.retrieveSyndromePatientStatistic();
	}

	@RequestMapping(value = "/patient/by_sex", method = RequestMethod.GET)
	public @ResponseBody List retrievePatientSexStatistic() {
		return statisticService.retrievePatientSexStatistic();
	}
	
	@RequestMapping(value = "/user/insufficiency", method = RequestMethod.GET)
	public @ResponseBody List retrieveInsufficiency() {
		return statisticService.retrieveInsufficiency(userId);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showPatient(ModelMap model, @PathVariable("id") int number) {
		User user = UserUtils.getCurrentUser();

		return "user/components/patient-info";
	}

	@RequestMapping(value = "/setDrugName", method = RequestMethod.POST)
	public @ResponseBody Boolean getDrugName(Model model,
			@RequestParam String nameOfDrugs) {
		if (nameOfDrugs == null) {
			return false;
		} else {
			this.nameOfDrugs = nameOfDrugs;
			System.out.println(nameOfDrugs);
			return true;
		}
	}

	@RequestMapping(value = "/drug/by_tolerance", method = RequestMethod.GET)
	public @ResponseBody List retrieveDrugTolerance() {
		return drugService.retrieveDrugTolerance(nameOfDrugs);
	}

	@RequestMapping(value = "/userId", method = RequestMethod.POST)
	public @ResponseBody Boolean getUserId(Model model,
			@RequestParam long userId) {
		if (userId == 0) {
			return false;
		} else {
			this.userId = userId;
			System.out.println(userId);
			return true;
		}
	}
}
