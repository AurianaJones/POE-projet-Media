package com.project.media.service.exception;

public class EmptyItemsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EmptyItemsException() {
		super("Il n'y a pas d'objets");
	}

}
