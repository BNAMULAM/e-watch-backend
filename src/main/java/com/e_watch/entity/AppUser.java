package com.e_watch.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.e_watch.enums.Role;
@Entity
public class AppUser {

	@Id
	private String userName;
	private String password;
	private Role role;
	private long mobileNumber;
	@OneToMany
	private List<Channel> channel;

	@Override
	public String toString() {
		return "AppUser [ userName=" + userName + ", password=" + password + ", role=" + role
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	public AppUser( String userName, String password, Role role, long mobileNumber) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;
	}
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<Channel> getChannel() {
		return channel;
	}
	public void setChannel(List<Channel> channel) {
		this.channel = channel;
	}

	
	
}
