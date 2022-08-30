package com.lti.server.exception;

public class UserPassMismatchException extends Exception{
    public UserPassMismatchException() {
        super();
    }

    public UserPassMismatchException(String message) {
        super(message);
    }

    public UserPassMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPassMismatchException(Throwable cause) {
        super(cause);
    }

    protected UserPassMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
