package com.divij.chatapplication.exception;

import java.util.HashMap;
import java.util.Map;

import com.divij.chatapplication.constants.BusinessExceptionEnum;

public class BusinessException {

	private String exceptionCode;
	private String exceptionMessage;
	private static Map<String, BusinessException> businessExceptionMap = new HashMap<>();

	private BusinessException(BusinessExceptionEnum b) {
		this.exceptionCode = b.getCode();
		this.exceptionMessage = b.getMessage();
	}

	public static BusinessException getBusinessException(BusinessExceptionEnum businessExceptionEnum) {

		BusinessException businessException;

		if (businessExceptionEnum.getCode() != null
				&& businessExceptionMap.containsKey(businessExceptionEnum.getCode())) {
			businessException = businessExceptionMap.get(businessExceptionEnum.getCode());
		} else {
			
			
			businessException = new BusinessException(businessExceptionEnum);
			
			businessExceptionMap.put(businessExceptionEnum.getCode(), businessException);
		}

		return businessException;
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
