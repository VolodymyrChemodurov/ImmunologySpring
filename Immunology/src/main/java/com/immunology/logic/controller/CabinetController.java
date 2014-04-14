package com.immunology.logic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cabinet")
public class CabinetController {

	@RequestMapping(method = RequestMethod.GET)
	public String cabinet() {
		return "user/cabinet";
	}
}
