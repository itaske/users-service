package com.iapl.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int code;
    private String status;
    private String message;

    private String timestamp;
}
