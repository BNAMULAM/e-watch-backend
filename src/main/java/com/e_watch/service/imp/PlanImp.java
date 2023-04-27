package com.e_watch.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.e_watch.dto.ChannelModel;
import com.e_watch.dto.PlanModel;
import com.e_watch.dto.PlanResponse;
import com.e_watch.entity.Channel;
import com.e_watch.entity.Plan;
import com.e_watch.entity.Promoter;
import com.e_watch.exceptions.IdNotFoundException;
import com.e_watch.exceptions.ResourceNotFoundException;
import com.e_watch.repo.ChannelRepo;
import com.e_watch.repo.PlanRepo;
import com.e_watch.service.Planservice;
@Service
public class PlanImp implements Planservice {
	
	@Autowired 
	PlanRepo planRepo;
	@Autowired
	ChannelRepo channelRepo;	
	@Override
	public PlanResponse insert(PlanModel planModel) {
		Plan plan =new Plan();
		plan.setName(planModel.getName());
		System.err.println(planModel.getName());
		plan.setAmountperMonth(planModel.getAmountperMonth());
		plan.setDetails(planModel.getDetails());
		plan.setTaxpercent(planModel.getTaxpercent());
		Channel chennel = this.channelRepo.findById(planModel.getChannelid()).get();
		plan.setChannel(chennel);
		Plan save = this.planRepo.save(plan);
		PlanResponse planResponse=new PlanResponse();
		planResponse.setId(save.getId());
		planResponse.setName(save.getName());
		planResponse.setAmountperMonth(save.getAmountperMonth());
		planResponse.setDetails(save.getDetails());
		planResponse.setTaxpercent(save.getTaxpercent());
		planResponse.setChannelName(chennel.getName());
		
		return planResponse;
	}

	@Override
	public List<PlanResponse> all() {
		List<PlanResponse> plan2=new ArrayList<>();
		List<Plan> findAll = this.planRepo.findAll();
		findAll.forEach(data->{
			PlanResponse planResponse =new PlanResponse();
			planResponse.setId(data.getId());
			planResponse.setAmountperMonth(data.getAmountperMonth());
			planResponse.setName(data.getName());
			planResponse.setTaxpercent(data.getTaxpercent());
			planResponse.setDetails(data.getDetails());
			Channel c=data.getChannel();
			String name=c.getName();
			planResponse.setChannelName(name);
			
			
			plan2.add(planResponse);
		});
		
		
		return plan2;
	}
	
	@Override
    public PlanModel update(PlanModel planModel) throws ResourceNotFoundException  {
         Optional<Plan> planoptional = planRepo.findById(planModel.getId());
         if(planoptional.isPresent()) {
             Plan existingplan = planoptional.get();
             existingplan.setAmountperMonth(planModel.getAmountperMonth());
             existingplan.setDetails(planModel.getDetails());
             existingplan.setName(planModel.getName());
             existingplan.setTaxpercent(planModel.getTaxpercent());
             Plan updatedplan =planRepo.save(existingplan);
             if(updatedplan.getName().equals(planModel.getName())) 
             {
                  return planModel;
             }
             else 
             	{
                throw new ResourceNotFoundException("something went wrong plan is not updated");
             	}
            }
        else {
           throw new ResourceNotFoundException("Plan id not found");
             }
	}


	

	@Override
	public String delete(Long id) throws ResourceNotFoundException {
	    try {
	        this.planRepo.deleteById(id);
	        return "data deleted";
	    } catch (Exception ex) {
	        throw new ResourceNotFoundException("Id not found: " + id);
	    }
	}

	@Override
	public PlanModel findById(Long id) throws ResourceNotFoundException {
        Optional<Plan> planoptional = planRepo.findById(id);
        if(planoptional.isPresent()) {
           Plan existingplan = planoptional.get();
           PlanModel planmodel = new PlanModel();
           planmodel.setAmountperMonth(existingplan.getAmountperMonth());
           planmodel.setDetails(existingplan.getDetails());
           planmodel.setName(existingplan.getName());
           planmodel.setTaxpercent(existingplan.getTaxpercent());
           planmodel.setId(existingplan.getId());
           planmodel.setChannelid(existingplan.getChannel().getId());
           return planmodel;
                      
        }
        else {
                      throw new ResourceNotFoundException("plan doesnot exits");

        }

	}
	
}
