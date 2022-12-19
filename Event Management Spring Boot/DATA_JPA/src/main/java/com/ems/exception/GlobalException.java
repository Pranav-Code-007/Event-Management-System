package com.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ems.exception.InvalidInputException;
import com.ems.exception.RecordNotFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.OK);						
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInputException(InvalidInputException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.OK);
	}

}
