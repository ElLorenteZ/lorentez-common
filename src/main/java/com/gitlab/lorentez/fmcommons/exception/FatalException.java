package com.gitlab.lorentez.fmcommons.exception;

public class FatalException extends RuntimeException implements FmException {

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
