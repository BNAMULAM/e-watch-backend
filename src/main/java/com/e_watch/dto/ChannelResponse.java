package com.e_watch.dto;

import java.util.List;

public class ChannelResponse {

	private long id;
	private String name;
	
	private String promoterName;

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

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public ChannelResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChannelResponse(long id, String name, String promoterName) {
		super();
		this.id = id;
		this.name = name;
		this.promoterName = promoterName;
	}

	@Override
	public String toString() {
		return "ChannelRespose [id=" + id + ", name=" + name + ", promoterName=" + promoterName + "]";
	}

	
	
}
