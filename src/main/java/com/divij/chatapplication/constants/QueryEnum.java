package com.divij.chatapplication.constants;

public enum QueryEnum {

	CHECK_IF_USER_EXISTS_QUERY("select count(*) From User usr where usr.userName=:usrName"),

	GET_UNREAD_MESSAGES(
			"From Message msg where msg.sender.userName=:senderId and msg.receiver.userName=:receiverId and msg.isRead=:readValue order by msg.messageTimestamp");
	
	
	

	private String query;

	private QueryEnum(String query) {
		this.query = query;
	}

	public String getQuery() {
		return this.query;
	}

}
