package com.sweetopia.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> noUserFoundException(UserNotFoundException unf, WebRequest wr){
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
	
	
	/* Exception handler for Order Bill Not Found*/
	@ExceptionHandler(OrderBillNotFoundException.class)
	public ResponseEntity<String> OrdrBillNotFoundException(OrderBillNotFoundException obnf, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDate.now());
		ed.setMessage(obnf.getMessage());
		ed.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>("OrderBill Not Found "+ed, HttpStatus.BAD_REQUEST);
		
	}
	/* Exception handler for Order Not Found*/
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> OrdrNotFoundException(OrderNotFoundException onf, WebRequest wr){
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDate.now());
		ed.setMessage(onf.getMessage());
		ed.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>("Order Not Found "+ed, HttpStatus.BAD_REQUEST);
		
	}

}
