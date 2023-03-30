package com.sweetopia.exception;

public class CartNotFoundException extends RuntimeException{

	public CartNotFoundException(String massage) {
		super(massage);
	}
}
