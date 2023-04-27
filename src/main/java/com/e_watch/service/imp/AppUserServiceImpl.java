package com.e_watch.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_watch.dto.AppUserDTO;
import com.e_watch.dto.AppUserResponse;
import com.e_watch.dto.LoginDTO;
import com.e_watch.entity.AppUser;
import com.e_watch.exceptions.AppUserException;
import com.e_watch.repo.AppUserRepo;
import com.e_watch.service.AppUserService;
@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserRepo repo;
	
	@Override
	public AppUserResponse validate(LoginDTO dto) {
		AppUser appuser = repo.findById(dto.getUserName()).orElse(null);
		System.out.println(appuser);
		if(appuser!=null && appuser.getPassword().equals(dto.getPassword())) {
			
			AppUserResponse userResponse= new AppUserResponse();
	        userResponse.setUserName(appuser.getUserName());
	        userResponse.setPassword(appuser.getPassword());
	        userResponse.setRole(appuser.getRole());
	        userResponse.setMobileNumber(appuser.getMobileNumber());
	        return userResponse;
		}
		return null;

	}

	public AppUserResponse register(AppUserDTO appuserDTO) throws AppUserException {
	    Optional<AppUser> existingAppUser = repo.findById(appuserDTO.getUserName());
	    if (existingAppUser.isPresent()) {
	        throw new AppUserException("App User Already exists");
	    } else {
	        AppUser appuser = new AppUser();
	        appuser.setUserName(appuserDTO.getUserName());
	        appuser.setPassword(appuserDTO.getPassword());
	        appuser.setRole(appuserDTO.getRole());
	        appuser.setMobileNumber(appuserDTO.getMobileNumber());
	        // set other fields in AppUser from AppUserDTO
	        AppUser save=this.repo.save(appuser);
	        AppUserResponse userResponse= new AppUserResponse();
	        userResponse.setUserName(save.getUserName());
	        userResponse.setPassword(save.getPassword());
	        userResponse.setRole(save.getRole());
	        userResponse.setMobileNumber(save.getMobileNumber());
	        return userResponse;
	    }
	}









}
