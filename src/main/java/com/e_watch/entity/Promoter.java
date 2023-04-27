package com.e_watch.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity

public class Promoter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy ="promoter")
	private List<Channel> channels;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public Promoter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promoter(Long id, String name, List<Channel> channels) {
		super();
		this.id = id;
		this.name = name;
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "Promoter [id=" + id + ", name=" + name + ", channels=" + channels + "]";
	}
	

}
