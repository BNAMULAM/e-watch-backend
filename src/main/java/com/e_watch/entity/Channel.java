package com.e_watch.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity

public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;
	private String name;
	@OneToMany(mappedBy ="channel")
	private List<Plan> plans;
	@ManyToOne 
	private Promoter promoter;
	
	public Channel(long id, String name, List<Plan> plans, Promoter promoter) {
		super();
		this.id = id;
		this.name = name;
		this.plans = plans;
		this.promoter = promoter;
	}
	public Channel() {
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
	public List<Plan> getPlans() {
		return plans;
	}
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	public Promoter getPromoter() {
		return promoter;
	}
	public void setPromoter(Promoter promoter) {
		this.promoter = promoter;
	}


}
