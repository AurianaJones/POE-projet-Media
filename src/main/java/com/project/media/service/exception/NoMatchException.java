package com.project.media.service.exception;

public class NoMatchException extends Exception{

	private static final long serialVersionUID = 1L;

    public NoMatchException(String msg){
        super("Pas de correspondance trouvé avec " + msg);
    }
    
}
