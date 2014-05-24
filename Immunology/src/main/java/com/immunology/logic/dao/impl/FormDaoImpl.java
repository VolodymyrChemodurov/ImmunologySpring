package com.immunology.logic.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.FormDao;

@Repository
public class FormDaoImpl implements FormDao{
	@PersistenceContext
	private EntityManager em;

}
