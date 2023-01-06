package com.my.interview.project.web.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RestControllerBase.BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerBase {
    public final static String BASE_URI = "/api/interview/project";
}
