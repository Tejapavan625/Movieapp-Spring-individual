package com.movieapp.exception;

public class MovieNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException() {
		super();
	}

	public MovieNotFoundException(String message) {
		super(message);
	}

}
