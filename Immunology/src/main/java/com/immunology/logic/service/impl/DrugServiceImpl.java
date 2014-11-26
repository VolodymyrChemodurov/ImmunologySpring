package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.DrugDao;
import com.immunology.logic.service.DrugService;
import com.immunology.model.Drug;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private CrudDao crudDao;

	@Autowired
	DrugDao drugDao;

	public List<Drug> getAllDrags() {
		return crudDao.getAll(Drug.class);
	}

	public List getDrugSpecies(String type) {
		return drugDao.getDrugSpecies(type);
	}

	public List<Drug> getDrugsType() {
		return drugDao.getDrugsType();
	}

	public List getDrugNames(String species) {
		return drugDao.getDrugNames(species);
	}

}
