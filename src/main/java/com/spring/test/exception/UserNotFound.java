package com.spring.test.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{
    String message;
    HttpStatus status;
    public UserNotFound() {

    }

    public UserNotFound(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public UserNotFound(String message) {
        super(String.valueOf(HttpStatus.NOT_FOUND));
        this.message = message;
    }

    public UserNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFound(Throwable cause) {
        super(cause);
    }

    public UserNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
