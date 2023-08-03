package com.mircoservices.ticketingservice.customexception;


public class FallbackException extends RuntimeException  {
    public FallbackException(String message) {
        super(message);
    }

    public FallbackException(String message, Throwable cause) {
        super(message, cause);
    }
}
