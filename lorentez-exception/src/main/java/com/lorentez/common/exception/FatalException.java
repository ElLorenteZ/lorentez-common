package com.lorentez.common.exception;

public class FatalException extends RuntimeException implements PrintableException {

    public FatalException(String message) {
        super(message);
    }

    public FatalException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public ExceptionProjection toProjection(){
        return ExceptionProjection.of(this.getClass().getSimpleName(), this.getMessage());
    }
}
