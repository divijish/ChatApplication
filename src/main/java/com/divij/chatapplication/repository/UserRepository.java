package com.divij.chatapplication.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.divij.chatapplication.entity.User;
import com.divij.chatapplication.entity.UserAuth;

@Repository
public interface UserRepository {

	public List<User> getUsers();

	public void createUser(User user);

	public User getUserByName(String userId);

	public boolean checkIfUserExists(String userName);

	public void registerUser(UserAuth userAuth);
}
