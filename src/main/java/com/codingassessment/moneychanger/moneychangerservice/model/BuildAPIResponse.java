package com.codingassessment.moneychanger.moneychangerservice.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
public class BuildAPIResponse {
    private final String message;
    private final HttpStatus httpStatus;
    private final String statusCode;
    private final Date timestamp;
    private final Object data;

    public BuildAPIResponse(String message, HttpStatus httpStatus, String statusCode, Date timestamp, Object data) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.data = data;
    }
}
