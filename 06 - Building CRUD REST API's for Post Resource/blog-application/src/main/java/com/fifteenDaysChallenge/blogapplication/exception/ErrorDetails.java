package com.fifteenDaysChallenge.blogapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

//@AllArgsConstructor
//@Getter
public class ErrorDetails {
    private Date timeStamp;
    private String message;
    private String details;

    public ErrorDetails(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
