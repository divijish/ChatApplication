package com.divij.chatapplication.common;

import org.springframework.stereotype.Component;

import com.divij.chatapplication.dto.UserAuthDto;
import com.divij.chatapplication.dto.UserRegistrationDto;

@Component
public class CommonUtils {

	private final static String EMPTY_STRING = "";

	public static boolean isNullString(String dataString) {

		boolean isEmptyString = true;

		if (!(null == dataString || EMPTY_STRING.equals(dataString) || EMPTY_STRING.equals(dataString.trim()))) {
			isEmptyString = false;
		}

		return isEmptyString;
	}

	public static boolean isNullObject(final Object object) {

		boolean isNullObject = true;

		if (!(null == object)) {
			isNullObject = false;
		}

		return isNullObject;

	}

	public static boolean isNullUserRegistrationDto(final UserRegistrationDto userDto) {

		boolean isNullUserDto = true;

		if (!(isNullObject(userDto) || isNullString(userDto.getUserName()) || isNullString(userDto.getPassword()))) {
			isNullUserDto = false;
		}

		return isNullUserDto;
	}

	public static boolean isNullUserAuthDto(final UserAuthDto userAuthDto) {

		boolean isNullObject = true;

		if (!(isNullObject(userAuthDto) || isNullString(userAuthDto.getUserName())
				|| isNullString(userAuthDto.getPassword()))) {
			isNullObject = false;
		}

		return isNullObject;
	}

}
