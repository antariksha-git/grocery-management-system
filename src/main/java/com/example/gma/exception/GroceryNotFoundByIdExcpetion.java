package com.example.gma.exception;

@SuppressWarnings("serial")
public class GroceryNotFoundByIdExcpetion extends RuntimeException {
	
	private final String message;
	private final String redirect;

	public GroceryNotFoundByIdExcpetion(String message, String redirect) {
		this.message = message;
		this.redirect = redirect;
	}

	public String getMessage() {
		return message;
	}

	public String getRedirect() {
		return redirect;
	}

}
