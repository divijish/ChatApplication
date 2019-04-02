package com.divij.chatapplication.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USR_AUTH_TBL")
public class UserAuth {

	@Id
	@Column(name="UAT_USR_NAME") 
	private String userName;
	
	@Column(name="UAT_PSSWRD")
	private String password;
	
	@Column(name="UAT_RGSTRD_TMSTMP")
	private Timestamp registeredTimestamp;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegisteredTimestamp() {
		return registeredTimestamp;
	}

	public void setRegisteredTimestamp(Timestamp registeredTimestamp) {
		this.registeredTimestamp = registeredTimestamp;
	}

}
