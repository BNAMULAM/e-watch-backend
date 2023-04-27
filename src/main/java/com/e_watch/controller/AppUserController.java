package com.e_watch.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_watch.dto.AppUserDTO;
import com.e_watch.dto.AppUserResponse;
import com.e_watch.dto.LoginDTO;
import com.e_watch.entity.AppUser;

import com.e_watch.exceptions.AppUserException;
import com.e_watch.service.AppUserService;
@RestController
@RequestMapping("/watch")
public class AppUserController {
	
	@Autowired
	private AppUserService service;
	

	@PostMapping("/validate")
	public ResponseEntity<?> validate( @RequestBody LoginDTO loginDTO) {
	    AppUserResponse response = service.validate(loginDTO);
	    if (response != null) {
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } else {
	    	return ResponseEntity.badRequest().body("Incorrect userName OR Password");
	    }
	}

	@PostMapping("/register")
	public ResponseEntity<AppUserResponse> register(@RequestBody AppUserDTO appUserDTO) throws AppUserException {
		return new ResponseEntity<AppUserResponse>(service.register(appUserDTO),HttpStatus.CREATED);

	}

}

