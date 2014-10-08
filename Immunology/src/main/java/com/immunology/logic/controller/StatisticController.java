package com.immunology.logic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.StatisticService;

@Controller
@RequestMapping("statistic")
public class StatisticController {

	public static final Logger LOG = LoggerFactory.getLogger(StatisticController.class);
	
	@Autowired
	private StatisticService statisticService;
	
	@RequestMapping(value = "/medical_cards/by_years", method = RequestMethod.GET)
	public @ResponseBody List retrieveMedicalCardCreationStatistic() {
		return statisticService.retrieveMedicalCardCreationStatistic();
	}
	
}
