package com.project.media.service.exception;

public class MaxBorrowException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MaxBorrowException(String msg) {
		super("Nombre d'empurnt maximum de 3 dépasser." + msg);
	}

}
