package com.my.interview.project.core.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ForbiddenException extends Exception {

    private final HttpStatus httpStatus = HttpStatus.FORBIDDEN;

    private String errorMessageCode;

    public ForbiddenException(String message) {
        super(message);
    }
}
