package com.sweetopia.exception;

public class InvalidCartException extends RuntimeException{

	public InvalidCartException(String massage) {
		super(massage);
	}
}
