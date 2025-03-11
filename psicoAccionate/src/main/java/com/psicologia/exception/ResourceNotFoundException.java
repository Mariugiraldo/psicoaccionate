package com.psicologia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	  public ResourceNotFoundException(String msg) {
			super(msg);
	  }

}
