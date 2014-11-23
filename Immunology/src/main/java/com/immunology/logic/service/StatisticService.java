package com.immunology.logic.service;

import java.util.List;

public interface StatisticService {

	List retrieveMedicalCardCreationStatistic();

	List retrieveSyndromePatientStatistic();

	List retrievePatientSexStatistic();

	List retrieveInsufficiency(long userId);
}
