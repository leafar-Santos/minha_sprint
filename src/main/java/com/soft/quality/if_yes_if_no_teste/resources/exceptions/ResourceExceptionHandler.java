package com.soft.quality.if_yes_if_no_teste.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.soft.quality.if_yes_if_no_teste.services.exceptions.DadosIntegrityViolationException;
import com.soft.quality.if_yes_if_no_teste.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler  {


	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError>objectNotFounException(ObjectNotFoundException e, ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DadosIntegrityViolationException.class)
	public ResponseEntity<StandardError>dataIntegrityViolationException(DadosIntegrityViolationException e, ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErrorFiled> ValidationError(MethodArgumentNotValidException e, ServletRequest request){
		
		ValidationError error = new ValidationError("Error ao preencher os campos abaixo: ");
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
		error.addErrors(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}



