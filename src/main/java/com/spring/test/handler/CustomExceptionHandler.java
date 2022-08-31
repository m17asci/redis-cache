package com.spring.test.handler;


import com.spring.test.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = UserNotFound.class)
    public UserNotFound exception(UserNotFound exception) {
        return new UserNotFound(HttpStatus.NOT_FOUND,exception.getMessage());
    }
}
