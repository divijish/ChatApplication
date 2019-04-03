package com.divij.chatapplication.service;

import java.util.List;

import com.divij.chatapplication.dto.UserAuthDto;
import com.divij.chatapplication.exception.BusinessException;

public interface LoginService {
	
	List<BusinessException> authenticateUser(UserAuthDto userAuthDto, List<BusinessException> businessException);
		
}
