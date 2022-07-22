package com.soft.quality.if_yes_if_no_teste.resources.exceptions;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends  StandardErrorFiled {

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
	
	}

	public ValidationError(String error) {
		super(error);
		
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String campo, String message) {
		this.errors.add(new FieldMessage(campo, message));
	}
	
}
