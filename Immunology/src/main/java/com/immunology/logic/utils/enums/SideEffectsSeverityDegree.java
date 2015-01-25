package com.immunology.logic.utils.enums;

public enum SideEffectsSeverityDegree {
	
	LIGHT("LIGHT"), MEDIUM("MEDIUM"), HARD("HARD");
	
	private SideEffectsSeverityDegree(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}
	
}
