package com.divij.chatapplication.repository;

import com.divij.chatapplication.dto.UserAuthDto;

public interface LoginRepository {

	public boolean authenticateUser(UserAuthDto userAuthDto);
}
