package com.galeria.dtos;

public class UsersDTO {

	private String userId;
	private String userName;
	private String userPasswd;
	private String userEmail;
	
	
	public UsersDTO() {
		super();
	}
	public UsersDTO(String userId, String userName, String userPasswd, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPasswd = userPasswd;
		this.userEmail = userEmail;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	

	
}
