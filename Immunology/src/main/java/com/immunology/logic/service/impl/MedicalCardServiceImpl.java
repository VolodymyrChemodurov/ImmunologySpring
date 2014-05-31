package com.immunology.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.model.ui.MedicalCardForm;

@Service
public class MedicalCardServiceImpl implements MedicalCardFormService{

	@Autowired
	private CrudDao crudDao;
	
	public MedicalCardForm getById(long id) {
		return crudDao.find(MedicalCardForm.class, id);
	}
	
}
