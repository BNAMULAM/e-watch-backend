package com.e_watch.dto;


import com.e_watch.enums.Role;

public class AppUserResponse {

	private String userName;
	private String password;
	private Role role;
	private long mobileNumber;
	
	@Override
	public String toString() {
		return "AppUserModel [userName=" + userName + ", password=" + password + ", role=" + role
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	public AppUserResponse(String userName, String password, Role role, long mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public AppUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}