package com.project.media.service.exception;

public class OutOfStockException extends Exception{

    public OutOfStockException(String msg){
        super(msg + " n'est plus en stock");
    }
    
}
