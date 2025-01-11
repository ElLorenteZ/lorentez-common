package com.lorentez.common.exception;

public class ObjectNotFoundException extends RuntimeException implements PrintableException {

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public ExceptionProjection toProjection(){
        return ExceptionProjection.of(this.getClass().getSimpleName(), this.getMessage());
    }
}
