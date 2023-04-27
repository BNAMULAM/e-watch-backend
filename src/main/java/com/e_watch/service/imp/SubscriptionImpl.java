package com.e_watch.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_watch.dto.ChannelResponse;
import com.e_watch.dto.SubscribedChannels;
import com.e_watch.entity.AppUser;
import com.e_watch.entity.Channel;
import com.e_watch.entity.Plan;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.repo.AppUserRepo;
import com.e_watch.repo.ChannelRepo;
import com.e_watch.repo.PlanRepo;
import com.e_watch.service.SubscriptionService;
@Service
public class SubscriptionImpl implements SubscriptionService{
	@Autowired
	private AppUserRepo userRepo;
	@Autowired 
	ChannelRepo channelRepo;
	@Autowired 
	PlanRepo planRepo;

	@Override
	public String subscribe(String userName, Long channelid, Long planid) throws IdNotFoundException {
		AppUser user = this.userRepo.findById(userName).orElseThrow(() -> new IdNotFoundException("user not found"));
		Channel channel = this.channelRepo.findById(channelid).orElseThrow(() -> new IdNotFoundException("channel not found"));
		Plan plan = this.planRepo.findById(planid).orElseThrow(() -> new IdNotFoundException("plan not found"));
		List<Plan> p=channel.getPlans();
		p.add(plan);
		channel.setPlans(p);
		List<Channel> userChannels=user.getChannel();
		userChannels.add(channel);
		userRepo.save(user);
		return "You can procced to payment";
	}

	@Override
	public List<SubscribedChannels> viewSubcription(String userName) throws IdNotFoundException {
		AppUser user = this.userRepo.findById(userName).orElseThrow(() -> new IdNotFoundException("user not found"));
		List<Channel> userchannels=user.getChannel();
		List<SubscribedChannels> s=new ArrayList<>();
		userchannels.stream().forEach(channel->{
			SubscribedChannels sb=new SubscribedChannels(channel.getId(), channel.getName());
			s.add(sb);
		}
				);
		
		return s;
	}

}
