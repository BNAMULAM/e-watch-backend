package com.e_watch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name ;
	private Double amountperMonth;
	private String details;
	private Float taxpercent;
	@ManyToOne
	private Channel channel;
	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", amountperMonth=" + amountperMonth + ", details=" + details
				+ ", taxpercent=" + taxpercent + ", channel=" + channel + "]";
	}
	public Plan(long id, String name, Double amountperMonth, String details, Float taxpercent, Channel channel) {
		super();
		this.id = id;
		this.name = name;
		this.amountperMonth = amountperMonth;
		this.details = details;
		this.taxpercent = taxpercent;
		this.channel = channel;
	}
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
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
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
	