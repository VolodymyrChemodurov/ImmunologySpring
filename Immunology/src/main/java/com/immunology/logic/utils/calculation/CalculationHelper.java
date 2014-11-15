package com.immunology.logic.utils.calculation;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculationHelper {

	private static final Logger LOG = LoggerFactory.getLogger(CalculationHelper.class);
	
	public static Boolean validateFormula(String formula) {
		boolean validationResult = false;
		try {
			Expression expression = new ExpressionBuilder(formula).variable("x").build();
			validationResult = expression.validate(false).isValid();
		} catch (Exception e) {
			LOG.error(e.toString());
			validationResult = false;
		}
		return validationResult;
	}
}
