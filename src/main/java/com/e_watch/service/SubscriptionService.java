package com.e_watch.service;

import java.util.List;

import com.e_watch.dto.ChannelResponse;
import com.e_watch.dto.SubscribedChannels;
import com.e_watch.entity.Channel;
import com.e_watch.exceptions.IdNotFoundException;

public interface SubscriptionService {
	public String subscribe( String userName,Long channelid,Long planid) throws IdNotFoundException;
	public List<SubscribedChannels> viewSubcription(String userName) throws IdNotFoundException;

}
 