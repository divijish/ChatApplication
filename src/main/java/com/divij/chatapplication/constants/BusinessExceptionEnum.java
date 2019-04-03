package com.divij.chatapplication.constants;

public enum BusinessExceptionEnum {

	USERNAME_OR_PASSWORD_INVALID("", "UserName or password is invalid."),
	INVALID_REQUEST_BODY("", "Request Body received is invalid."),
	USER_ALREADY_EXISTS("", "User with provided name already exists."), NO_RECEIVER_USER("", "Receiver does not exist"),
	NO_SENDER_USER("", "Sender does not exist"), NO_USER_PRESENT("", "No user with the provided id is present");

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
