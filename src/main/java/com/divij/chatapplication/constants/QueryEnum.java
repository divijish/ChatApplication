package com.divij.chatapplication.constants;

public enum QueryEnum {

	CHECK_IF_USER_EXISTS_QUERY("select count(*) From User usr where usr.userName=:usrName");

	private String query;

	private QueryEnum(String query) {
		this.query = query;
	}

	public String getQuery() {
		return this.query;
	}

}
