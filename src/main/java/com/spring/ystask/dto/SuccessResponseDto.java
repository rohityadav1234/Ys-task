package com.spring.ystask.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.ystask.enums.SuccessCodes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponseDto {

    private List<String> msg = new ArrayList<>();
    private boolean status = true;
    private SuccessCodes successCode;
    private int statusCode = 200;
    private Map<String, Object> extraData = new HashMap<>();

}
