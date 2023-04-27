package com.e_watch.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_watch.dto.PromoterResponse;
import com.e_watch.dto.Promotermodel;
import com.e_watch.entity.Promoter;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.repo.PromoterRepo;
import com.e_watch.service.PromoterService;

@Service
public class PromoterImpl implements PromoterService {
	@Autowired
	PromoterRepo promoterRepo;

	@Override
	public PromoterResponse insert(Promotermodel promotermodel) {
		Promoter promoter2 = new Promoter();
		promoter2.setName(promotermodel.getName());
		Promoter save = this.promoterRepo.save(promoter2);
		PromoterResponse promoterRespose = new PromoterResponse();
		promoterRespose.setId(save.getId());
		promoterRespose.setName(save.getName());
		return promoterRespose;
	}

	@Override
	public List<PromoterResponse> all() {
		List<PromoterResponse> proResposes = new ArrayList<>();
		List<Promoter> findAll = this.promoterRepo.findAll();
		findAll.forEach(data -> {
			PromoterResponse promoterRespose = new PromoterResponse();
			promoterRespose.setId(data.getId());
			promoterRespose.setName(data.getName());
			proResposes.add(promoterRespose);
		});
		return proResposes;
	}
	




	@Override
	public String delete(long id) throws IdNotFoundException {
	    try {
	        this.promoterRepo.deleteById(id);
	        return "data deleted";
	    } catch (Exception ex) {
	        throw new IdNotFoundException("Id not found: " + id);
	    }
	}


	@Override
	public Promotermodel update(Promotermodel promotermodel) {
		Promoter promoter2 = new Promoter();
		promoter2.setId(promotermodel.getId());
		promoter2.setName(promotermodel.getName());
		Promoter save = this.promoterRepo.save(promoter2);
		PromoterResponse promoterRespose = new PromoterResponse();
		promoterRespose.setId(save.getId());
		promoterRespose.setName(save.getName());
		return promotermodel;

	}

}
