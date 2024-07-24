package com.generation.backend.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.generation.backend.dto.EntityExceptionDTO;
import com.generation.backend.exception.NotYourUserException;
import com.generation.backend.exception.UserNotFoundException;

@RestControllerAdvice
public class ControllersExceptionHandler
{
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public EntityExceptionDTO userNotFoundExceptionHandler(UserNotFoundException e)
    {
        EntityExceptionDTO res = new EntityExceptionDTO(e.getMessage(),"User");
        return res;
    }

    @ExceptionHandler(NotYourUserException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public EntityExceptionDTO notYourUser(NotYourUserException e)
    {
        EntityExceptionDTO res = new EntityExceptionDTO(e.getMessage(),"User");
        return res;
    }

}
