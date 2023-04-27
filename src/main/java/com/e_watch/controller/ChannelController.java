package com.e_watch.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_watch.dto.ChannelModel;
import com.e_watch.dto.ChannelResponse;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.exceptions.ResourceNotFoundException;
import com.e_watch.service.ChannelService;

@RestController
@RequestMapping("/channel")
public class ChannelController {
	
	@Autowired
	ChannelService channelService;
	@PostMapping("/post")
	public ChannelResponse insert( @RequestBody ChannelModel channelModel) {
		ChannelResponse insert = this.channelService.insert(channelModel);
		return insert;
	}

	@GetMapping("/get")
	public List<ChannelResponse> all(){
		List<ChannelResponse> all = this.channelService.all();
		return all;
	}

	@DeleteMapping("/delete/{id}")
	public String delete (@PathVariable Long id) throws ResourceNotFoundException {
		String delete = this.channelService.delete(id);
		return delete;
	}
	
	




}
