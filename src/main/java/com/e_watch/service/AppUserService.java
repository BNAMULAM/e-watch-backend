package com.e_watch.service;

import com.e_watch.entity.AppUser;
import com.e_watch.exceptions.AppUserException;
import com.e_watch.dto.AppUserDTO;
import com.e_watch.dto.AppUserResponse;
import com.e_watch.dto.LoginDTO;

public interface AppUserService {
	public AppUserResponse validate(LoginDTO dto);
	
	public AppUserResponse register(AppUserDTO appuserDTO) throws AppUserException;


}
