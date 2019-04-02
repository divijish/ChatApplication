package com.divij.chatapplication.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.divij.chatapplication.entity.User;

@Repository
public interface UserRepository {

	public List<User> getUsers();

	void saveUser(User user);
}
