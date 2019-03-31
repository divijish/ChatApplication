package com.divij.chatapplication.dto;

import java.util.ArrayList;
import java.util.List;

public class UserListDto {

	List<UserStatusDto> usersList = new ArrayList<>(0);

	public List<UserStatusDto> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserStatusDto> usersList) {
		this.usersList = usersList;
	}
	
}
