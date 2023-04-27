package com.e_watch.service;

import java.util.List;

import com.e_watch.dto.PlanModel;
import com.e_watch.dto.PlanResponse;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.exceptions.ResourceNotFoundException;

public interface Planservice  {
	
	public PlanResponse insert(PlanModel planModel);
	public List<PlanResponse> all();
	public PlanModel update (PlanModel planModel) throws ResourceNotFoundException ;
	public String delete(Long id) throws ResourceNotFoundException ;
	public PlanModel findById(Long id) throws ResourceNotFoundException ;
	 

}
