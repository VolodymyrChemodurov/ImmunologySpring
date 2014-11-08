package com.immunology.model.ui;

public enum DrugTolerance {

	GOOD("GOOD"), SATISFYING("SATISFYING"), BAD("BAD");
	
	private DrugTolerance(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}
}
