package com.lorentez.common.exception;

public class LogicException extends RuntimeException implements PrintableException {

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public ExceptionProjection toProjection(){
        return ExceptionProjection.of(this.getClass().getSimpleName(), this.getMessage());
    }

}
