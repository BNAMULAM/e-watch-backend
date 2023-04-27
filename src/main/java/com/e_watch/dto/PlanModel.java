package com.e_watch.dto;


import com.e_watch.entity.Channel;

public class PlanModel {
	
	private long id;
	private String name ;
	private Double amountperMonth;
	private String details;
	private Float taxpercent;
	
	private long channelid;

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

	public Double getAmountperMonth() {
		return amountperMonth;
	}

	public void setAmountperMonth(Double amountperMonth) {
		this.amountperMonth = amountperMonth;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Float getTaxpercent() {
		return taxpercent;
	}

	public void setTaxpercent(Float taxpercent) {
		this.taxpercent = taxpercent;
	}

	public long getChannelid() {
		return channelid;
	}

	public void setChannelid(long channelid) {
		this.channelid = channelid;
	}

	public PlanModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlanModel(long id, String name, Double amountperMonth, String details, Float taxpercent, long channelid) {
		super();
		this.id = id;
		this.name = name;
		this.amountperMonth = amountperMonth;
		this.details = details;
		this.taxpercent = taxpercent;
		this.channelid = channelid;
	}

	@Override
	public String toString() {
		return "PlanModel [id=" + id + ", name=" + name + ", amountperMonth=" + amountperMonth + ", details=" + details
				+ ", taxpercent=" + taxpercent + ", channelid=" + channelid + "]";
	}
	
	
}