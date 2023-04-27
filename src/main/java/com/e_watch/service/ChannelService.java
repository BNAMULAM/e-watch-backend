package com.e_watch.service;

import java.util.List;

import com.e_watch.dto.ChannelModel;
import com.e_watch.dto.ChannelResponse;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.exceptions.ResourceNotFoundException;

public interface ChannelService {
	
	public ChannelResponse insert(ChannelModel channelModel);
	public List<ChannelResponse> all();
	public String delete (Long id) throws ResourceNotFoundException;
	



}
