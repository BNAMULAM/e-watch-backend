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

import com.e_watch.dto.PromoterResponse;
import com.e_watch.dto.Promotermodel;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.service.PromoterService;

@RestController
@RequestMapping("/promoter")
public class PromoterController {

	@Autowired
	PromoterService promoterService;

		@PostMapping("/post")
		public PromoterResponse insert( @RequestBody Promotermodel promotermodel) {
		PromoterResponse inert = this.promoterService.insert(promotermodel);
		return inert;
		}

		@GetMapping("/get")
		public List<PromoterResponse> all() {
		List<PromoterResponse> all = this.promoterService.all();
		return all;
		}
		
		@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable("id") int id) throws IdNotFoundException {
		String delete = this.promoterService.delete(id);
		return delete;
		}
	
		@PutMapping("/put")
		public Promotermodel update(@RequestBody Promotermodel promotermodel) {
		Promotermodel update = this.promoterService.update(promotermodel);
		return update;
		}
}
