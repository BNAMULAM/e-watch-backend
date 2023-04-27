package com.e_watch.dto;



public class LoginDTO {
	
	
	private String userName;
	private String password;
	public LoginDTO(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
	}
	@Override
	public String toString() {
	return "LoginDTO [userName=" + userName + ", password=" + password + "]";
	}
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

}
