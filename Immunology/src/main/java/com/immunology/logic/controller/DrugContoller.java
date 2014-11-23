package com.immunology.logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.immunology.logic.service.DrugService;

@Controller
@RequestMapping(value = "/drugs")
public class DrugContoller {

	@Autowired
	private DrugService drugService;

}
