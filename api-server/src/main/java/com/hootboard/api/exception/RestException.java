package com.hootboard.api.exception;

public class RestException extends Exception {

    private static final long serialVersionUID = -2209565459892832687L;

    public RestException() {
        super();
    }

    public RestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(Throwable cause) {
        super(cause);
    }

}
