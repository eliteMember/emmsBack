package com.emms.cmmn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.emms.cmmn.exception.CustomException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
	
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<?> Exception(Exception e) {
	      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	   }
	
}