package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.immunology.logic.dao.MedicalCardFormDao;
import com.immunology.logic.service.StatisticService;

@Controller
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private MedicalCardFormDao medicalCardDao;
	
	public List retrieveMedicalCardCreationStatistic() {
		return medicalCardDao.retrieveMedicalCardCreationStatistic();
	}
	
}
