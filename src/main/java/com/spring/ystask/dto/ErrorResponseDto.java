package com.spring.ystask.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.ystask.enums.YsTaskException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {

    private List<String> msg = new ArrayList<>();
    private boolean status = false;
    private YsTaskException exception;
    private int statusCode = 404;
    Map<String, Object> extraData = new HashMap<>();
}
