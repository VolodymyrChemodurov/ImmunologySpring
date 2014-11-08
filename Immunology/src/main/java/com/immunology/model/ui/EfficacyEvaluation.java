package com.immunology.model.ui;

public enum EfficacyEvaluation {

	NO_EFFECT("NO_EFFECT"), HIGH("HIGH"), MODERATE("MODERATE");
	
	private EfficacyEvaluation(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}
}
