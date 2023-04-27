package com.e_watch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e_watch.dto.PromoterResponse;
import com.e_watch.dto.Promotermodel;
import com.e_watch.dto.SubscribedChannels;
import com.e_watch.entity.Channel;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.service.SubscriptionService;

@RestController
@RequestMapping("/subscribe")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;
	
	@PostMapping("/subscribed")
	public ResponseEntity<String> subscribe(@RequestParam String userName, @RequestParam Long channelid, @RequestParam Long planid) {
	    try {
	        String response = subscriptionService.subscribe(userName, channelid, planid);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (IdNotFoundException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/viewsubscription")
	public ResponseEntity<List<SubscribedChannels>> viewSubcription(@RequestParam String userName) {
        try {
            List<SubscribedChannels> subscriptions = (List<SubscribedChannels>) subscriptionService.viewSubcription(userName);
            return ResponseEntity.ok(subscriptions);
        } catch (IdNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}	





	


