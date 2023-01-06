package com.my.interview.project.core.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundException extends Exception {

    private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    private String errorMessageCode;

    public NotFoundException(String message) {
        super(message);
    }
}
