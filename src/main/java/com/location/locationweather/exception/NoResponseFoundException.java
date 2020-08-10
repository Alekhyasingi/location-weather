package com.location.locationweather.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoResponseFoundException extends Exception {
	public NoResponseFoundException() {
        super();
    }
    public NoResponseFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoResponseFoundException(String message) {
        super(message);
    }
    public NoResponseFoundException(Throwable cause) {
        super(cause);
    }
}
