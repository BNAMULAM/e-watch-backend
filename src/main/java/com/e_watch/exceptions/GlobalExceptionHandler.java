package com.e_watch.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(AppUserException.class)
	public ResponseEntity<String> handleAppUserException(AppUserException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

	}
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInputException(InvalidInputException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> IdException(IdNotFoundException em){
		return new ResponseEntity<String>(em.getMessage(),HttpStatus.CONFLICT);
		
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceException(ResourceNotFoundException em){
		return new ResponseEntity<String>(em.getMessage(),HttpStatus.CONFLICT);
		
	}
	

}