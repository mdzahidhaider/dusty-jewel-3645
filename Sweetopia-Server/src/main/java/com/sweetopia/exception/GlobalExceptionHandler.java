package com.sweetopia.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<String> noUserFoundException(UserNotFound unf, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDate.now());
		ed.setMessage(unf.getMessage());
		ed.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>("User Not Found"+ed, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> noEmployeeFound(Exception ex, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDate.now());
		ed.setMessage(ex.getMessage());
		ed.setDetails(wr.getDescription(false));
		
		
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
	}

}
