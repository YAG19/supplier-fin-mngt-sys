package com.capstoneproj.supfinsys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientException extends RuntimeException{

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseMessage handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex) {
        return new ResponseMessage("Username already exists");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseMessage handleUsernameNotFoundException(UsernameNotFoundException ex) {
        return new ResponseMessage("Username does not exist");
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage handleIncorrectPasswordException(IncorrectPasswordException ex) {
        return new ResponseMessage("Incorrect Password");
    }

}