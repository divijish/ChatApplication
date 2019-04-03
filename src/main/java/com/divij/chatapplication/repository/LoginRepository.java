package com.divij.chatapplication.repository;

import org.springframework.stereotype.Repository;

import com.divij.chatapplication.dto.UserAuthDto;

@Repository
public interface LoginRepository {

	public boolean authenticateUser(UserAuthDto userAuthDto);
}
