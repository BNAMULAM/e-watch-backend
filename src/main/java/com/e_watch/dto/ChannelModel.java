package com.e_watch.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;

public class ChannelModel {

	
	private String name;
	
	private Long promoterid;

	public Long getPromoterid() {
		return promoterid;
	}

	public void setPromoterid(Long promoterid) {
		this.promoterid = promoterid;
	}

	public ChannelModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChannelModel(String name, Long promoterid) {
		super();
		this.name = name;
		this.promoterid = promoterid;
	}

	@Override
	public String toString() {
		return "ChannelModel [name=" + name + ", promoterid=" + promoterid + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

}
