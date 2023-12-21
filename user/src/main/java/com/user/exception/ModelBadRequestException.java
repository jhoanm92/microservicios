package com.user.exception;

public class ModelBadRequestException extends RuntimeException{
    public ModelBadRequestException(String mensaje){
        super(mensaje);
    }
}
