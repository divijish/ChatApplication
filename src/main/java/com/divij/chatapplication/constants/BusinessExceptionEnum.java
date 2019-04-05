package com.divij.chatapplication.constants;

public enum BusinessExceptionEnum {

	USERNAME_OR_PASSWORD_INVALID("CA001", "UserName or password is invalid."),
	INVALID_REQUEST_BODY("CA002", "Request Body received is invalid."),
	USER_ALREADY_EXISTS("CA003", "User with provided name already exists."), NO_RECEIVER_USER("CA004", "Receiver does not exist"),
	NO_SENDER_USER("CA005", "Sender does not exist"), NO_USER_PRESENT("CA006", "No user with the provided id is present"),
	USER_NOT_LOGGED_IN("CA007", "No user is logged in yet.");

	private String businessExceptionCode;
	private String businessExceptionMessage;

	private BusinessExceptionEnum(final String code, final String message) {
		this.businessExceptionCode = code;
		this.businessExceptionMessage = message;
	}

	public String getCode() {
		return this.businessExceptionCode;
	}

	public String getMessage() {
		return this.businessExceptionMessage;
	}

}
