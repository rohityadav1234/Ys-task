package com.spring.ystask.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.ystask.dto.ErrorResponseDto;
import com.spring.ystask.enums.YsTaskException;
import com.spring.ystask.exceptions.DepartmentException;


@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DepartmentException.class)
    ResponseEntity<Object> userException(final DepartmentException de) {
        ErrorResponseDto err = new ErrorResponseDto();
        err.setException(de.getException());
        err.getMsg().add(de.getMessage());
        return ResponseEntity.ok().body(err);
    }
    
    @ExceptionHandler(Exception.class)
    ResponseEntity<Object> exception(final Exception e) {
        ErrorResponseDto err = new ErrorResponseDto();
        err.setException(YsTaskException.FATAL_EXCEPTION);
        err.getMsg().add(e.getMessage());
        return ResponseEntity.ok().body(err);
    }

}
