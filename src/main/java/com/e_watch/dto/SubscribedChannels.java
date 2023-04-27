package com.e_watch.dto;

public class SubscribedChannels {
	private long id;
	private String name;
	@Override
	public String toString() {
		return "ViewSubscriptionDto [id=" + id + ", name=" + name + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SubscribedChannels(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
