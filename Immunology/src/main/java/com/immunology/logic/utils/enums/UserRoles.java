package com.immunology.logic.utils.enums;


public enum UserRoles {

	ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER"), ROLE_DOCTOR("ROLE_DOCTOR");

	private String value;
	
	private UserRoles(String roleName) {
		this.value = roleName;
	}

	public String getValue() {
		return value;
	}

}
