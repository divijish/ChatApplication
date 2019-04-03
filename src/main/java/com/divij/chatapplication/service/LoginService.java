package com.divij.chatapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.divij.chatapplication.dto.UserAuthDto;
import com.divij.chatapplication.exception.BusinessException;

@Service
public interface LoginService {
	
	List<BusinessException> authenticateUser(UserAuthDto userAuthDto, List<BusinessException> businessException);
		
}
