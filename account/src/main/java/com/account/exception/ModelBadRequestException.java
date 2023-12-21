package com.account.exception;

public class ModelBadRequestException extends RuntimeException{
    public ModelBadRequestException(String mensaje){
        super(mensaje);
    }
}
