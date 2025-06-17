package com.pa.api.personalauditor.exception;

public class PAException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PAException(String message) {
        super(message);
    }

    public PAException(String message, Throwable cause) {
        super(message, cause);
    }

    public PAException(Throwable cause) {
        super(cause);
    }
}
