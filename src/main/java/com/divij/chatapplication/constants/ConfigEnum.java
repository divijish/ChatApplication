package com.divij.chatapplication.constants;

import java.util.HashMap;

public enum ConfigEnum {

	PACKAGES_TO_SCAN("com.divij.chatapplication.entity"), HIBERNATE_HBM2DDL("hibernate.hbm2ddl.auto"),
	HIBERNATE_DIALECT("hibernate.dialect");

	private String property;

	private ConfigEnum(final String property) {
		this.property = property;
	}
	
	public String getValue() {
		return this.property;
	}
	

}
