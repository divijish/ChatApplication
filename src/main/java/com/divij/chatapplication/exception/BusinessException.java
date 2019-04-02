package com.divij.chatapplication.exception;

public class BusinessException {

	private String exceptionCode;
	private String exceptionMessage;

	public BusinessException(String exceptionCode, String exceptionMessage) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String toString() {
		return "BusinessException [exceptionCode=" + exceptionCode + ", exceptionMessage=" + exceptionMessage + "]";
	}
	
	

}
