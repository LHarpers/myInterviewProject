package com.my.interview.project.core.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ConflictException extends Exception {

    private final HttpStatus httpStatus = HttpStatus.CONFLICT;

    private String errorMessageCode;

    public ConflictException(String message) {
        super(message);
    }
}
