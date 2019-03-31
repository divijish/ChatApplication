package com.divij.chatapplication.repository;

import java.util.List;

import com.divij.chatapplication.dto.UserListDto;
import com.divij.chatapplication.entity.User;

public interface UserRepository {

	public List<User> getUsers();
}
