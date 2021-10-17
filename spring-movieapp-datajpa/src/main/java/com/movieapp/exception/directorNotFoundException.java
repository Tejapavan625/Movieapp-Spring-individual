package com.movieapp.exception;

public class directorNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public directorNotFoundException() {
		super();
	}

	public directorNotFoundException(String message) {
		super(message);
	}

}
