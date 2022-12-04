package com.psh.exception;

public class ExistSameBookException extends RuntimeException{

    public ExistSameBookException(String message){
        super(message);
    }
}
