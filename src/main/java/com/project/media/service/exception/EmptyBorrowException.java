package com.project.media.service.exception;

public class EmptyBorrowException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EmptyBorrowException() {
		super("Il n'y a rien a emprunter");
	}

}
