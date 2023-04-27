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

import com.e_watch.dto.PlanModel;
import com.e_watch.dto.PlanResponse;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.exceptions.ResourceNotFoundException;
import com.e_watch.service.Planservice;
@CrossOrigin
@RestController
@RequestMapping("/plan")
public class PlanController {
	@Autowired
	Planservice planservice;
	
	@PostMapping("/post")
	public PlanResponse insert(@RequestBody PlanModel planModel) {
		PlanResponse inert = this.planservice.insert(planModel);
		return inert;
	}
	
	@GetMapping("/get")
	public List<PlanResponse> all() {
		List<PlanResponse> all = this.planservice.all();
		return all;
	}
	
	@PutMapping("/put")
	public PlanModel update( @RequestBody PlanModel planModel) throws ResourceNotFoundException {
		System.out.println(planModel);
		PlanModel update = this.planservice.update(planModel);
		return update;
	}

	@GetMapping("/{id}")
    public PlanModel findById(@PathVariable Long id) throws IdNotFoundException, ResourceNotFoundException {
        return planservice.findById(id);
    }
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) throws ResourceNotFoundException {
		String delete = this.planservice.delete(id);
		return delete;
	}
}
