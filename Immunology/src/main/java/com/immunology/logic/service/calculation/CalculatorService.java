package com.immunology.logic.service.calculation;

import com.immunology.model.calculation.Formula;


public interface CalculatorService<T> {

	Double calculate(T entity, Formula Formula);
	
}
