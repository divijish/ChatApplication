package com.divij.chatapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USR_DTL")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "UD_USR_ID")
	private int userId;
	
	@Column(name = "UD_USR_NM")
	private String userName;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}