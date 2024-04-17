package com.galeria.dtos;

import java.util.List;

public class UsersDTO {
	private Integer userID;
	private String userName;
	private String userPasswd;
	private String userEmail;
	private List<String> user_role;
	
	public UsersDTO() {
		super();
	}

	public UsersDTO(Integer userID, String userName) {
		super();
		this.userID = userID;
		this.userName = userName;
	}

	public UsersDTO(Integer userID, String userName, String userPasswd, String userEmail) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.userEmail = userEmail;
	}

	public UsersDTO(Integer userID, String userName, String userPasswd, String userEmail, List<String> user_role) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.userEmail = userEmail;
		this.user_role = user_role;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<String> getUser_role() {
		return user_role;
	}

	public void setUser_role(List<String> user_role) {
		this.user_role = user_role;
	}
	
}
