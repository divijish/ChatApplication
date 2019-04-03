package com.divij.chatapplication.constants;

public enum ParameterConstants {

	USER_NAME("usrName"), SENDER_ID("senderId"), RECEIVER_ID("receiverId"), PASSWORD("password");

	private String parameter;

	private ParameterConstants(String parameter) {
		this.parameter = parameter;
	}

	public String getParameter() {
		return this.parameter;
	}

}
