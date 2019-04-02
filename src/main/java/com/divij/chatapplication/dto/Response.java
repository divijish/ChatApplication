package com.divij.chatapplication.dto;

import java.util.ArrayList;
import java.util.List;

import com.divij.chatapplication.exception.BusinessException;

public class Response<T> {
	
	private String status;
	
	private T result;
	
	private List<BusinessException> businessExceptions = new ArrayList<>(0);
	
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public List<BusinessException> getBusinessExceptions() {
		return businessExceptions;
	}

	public void setBusinessExceptions(List<BusinessException> businessExceptions) {
		this.businessExceptions = businessExceptions;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
