package com.divij.chatapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USR_DTL")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UD_USR_ID")
	private int userId;

	@Column(name = "UD_USR_NM")
	private String userName;
	
	@Column(name = "UD_PRFL_PIC_URL")
	private String profilePicUrl = "https://img.icons8.com/ios-glyphs/30/000000/user.png";
	
	

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}

	public User() {
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

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
