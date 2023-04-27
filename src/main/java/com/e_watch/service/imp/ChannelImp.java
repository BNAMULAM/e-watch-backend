package com.e_watch.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.e_watch.dto.ChannelModel;
import com.e_watch.dto.ChannelResponse;
import com.e_watch.entity.Channel;
import com.e_watch.entity.Promoter;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.exceptions.ResourceNotFoundException;
import com.e_watch.repo.AppUserRepo;
import com.e_watch.repo.ChannelRepo;
import com.e_watch.repo.PromoterRepo;
import com.e_watch.service.ChannelService;

@Service
public class ChannelImp implements ChannelService {
	@Autowired 
	ChannelRepo channelRepo;
	@Autowired 
	PromoterRepo promoterRepo;

	@Override
	public ChannelResponse insert(ChannelModel channelModel) {
		 Channel channel=new Channel(); 
		 channel.setName(channelModel.getName());
		 Promoter promoter = this.promoterRepo.findById(channelModel.getPromoterid()).get();
		 channel.setPromoter(promoter);
		 Channel save = this.channelRepo.save(channel);
		 ChannelResponse channelRespose=new ChannelResponse();
		 channelRespose.setId(save.getId());
		 channelRespose.setName(save.getName());
		 channelRespose.setPromoterName(promoter.getName());
		 return channelRespose;
	}
	




	@Override
	public List<ChannelResponse> all() {
		List<ChannelResponse> channelResponse=new ArrayList<>();
		List<Channel> findAll = this.channelRepo.findAll();
		findAll.forEach(data->{
			ChannelResponse channelResponse2=new ChannelResponse();
			channelResponse2.setId(data.getId());
			channelResponse2.setName(data.getName());
			Promoter p=data.getPromoter();
			String name=p.getName();
			channelResponse2.setPromoterName(name);
			channelResponse.add(channelResponse2);
			
			
		});
		return channelResponse;
	}

	@Override
	public String delete(Long id) throws ResourceNotFoundException {
	    try {
	        this.channelRepo.deleteById(id);
	        return "data deleted";
	    } catch (Exception ex) {
	        throw new ResourceNotFoundException("Id not found: " + id);
	    }
	}
	

}
