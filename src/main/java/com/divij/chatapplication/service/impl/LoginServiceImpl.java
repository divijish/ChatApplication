package com.divij.chatapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divij.chatapplication.common.CommonUtils;
import com.divij.chatapplication.constants.BusinessExceptionEnum;
import com.divij.chatapplication.dto.UserAuthDto;
import com.divij.chatapplication.exception.BusinessException;
import com.divij.chatapplication.repository.LoginRepository;
import com.divij.chatapplication.service.LoginService;
import com.divij.chatapplication.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserService userServiceImpl;

	@Autowired
	private LoginRepository loginRepositoryImpl;

	/*
	 * This method logs a user in the application. (non-Javadoc)
	 * 
	 * @see
	 * com.divij.chatapplication.service.LoginService#authenticateUser(com.divij.
	 * chatapplication.dto.UserAuthDto)
	 */
	@Override
	public List<BusinessException> authenticateUser(UserAuthDto userAuthDto,
			List<BusinessException> businessExceptions) {

		if (CommonUtils.isNullObject(userAuthDto)) {

			businessExceptions.add(BusinessException.getBusinessException(BusinessExceptionEnum.INVALID_REQUEST_BODY));

		} else if (CommonUtils.isNullString(userAuthDto.getUserName())
				|| CommonUtils.isNullString(userAuthDto.getPassword())) {

			businessExceptions
					.add(BusinessException.getBusinessException(BusinessExceptionEnum.USERNAME_OR_PASSWORD_INVALID));

		} else {

			boolean userAuthenticated = loginRepositoryImpl.authenticateUser(userAuthDto);

			if (!userAuthenticated) {
				businessExceptions.add(
						BusinessException.getBusinessException(BusinessExceptionEnum.USERNAME_OR_PASSWORD_INVALID));
			}

			boolean userExists = userServiceImpl.checkIfUserExists(userAuthDto.getUserName());

			if (!userExists) {
				businessExceptions.add(BusinessException.getBusinessException(BusinessExceptionEnum.NO_USER_PRESENT));
			}
		}

		return businessExceptions;
	}

}
