package com.e_watch.service;

import java.util.List;

import com.e_watch.dto.PromoterResponse;
import com.e_watch.dto.Promotermodel;
import com.e_watch.exceptions.IdNotFoundException;

public interface PromoterService {

	 public	PromoterResponse insert(Promotermodel promotermodel);
	 public List<PromoterResponse> all();
	 public String delete(long id) throws IdNotFoundException;
	 public Promotermodel update (Promotermodel promotermodel)  ;
	
}
