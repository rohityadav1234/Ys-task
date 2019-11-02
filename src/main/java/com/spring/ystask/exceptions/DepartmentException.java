package com.spring.ystask.exceptions;

import com.spring.ystask.enums.YsTaskException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentException extends Exception {

    private static final long serialVersionUID = 1L;

    private YsTaskException exception;

    public DepartmentException(String msg, YsTaskException exception) {
        super(msg);
        this.exception = exception;
    }

}
