package com.divij.chatapplication.common;

import org.springframework.stereotype.Component;

import com.divij.chatapplication.dto.UserRegistrationDto;

@Component
public class CommonUtils {
	
	private final static String EMPTY_STRING="";
	
	
	public static boolean isNullString(String dataString) {
		
		boolean isEmptyString = true;
		
		if(!(null==dataString || EMPTY_STRING.equals(dataString))) {
			isEmptyString = false;
		}
		
		return isEmptyString;
	}
	
	public static boolean isNullUserRegistrationDto(final UserRegistrationDto userDto) {
		
		boolean isNullUserDto = true;
		
		if(!(isNullObject(userDto)|| isNullString(userDto.getUserName()) || isNullString(userDto.getPassword()))) {
			isNullUserDto = false;
		}			
		
		return isNullUserDto;
	}
	
	public static boolean isNullObject(final Object object) {
		
		boolean isNullObject = true;
		
		if(!(null==object)) {
			isNullObject = false;
		}
		
		return isNullObject;
		
	}
	
}
