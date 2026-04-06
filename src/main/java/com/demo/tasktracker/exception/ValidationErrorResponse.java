package com.demo.tasktracker.exception;

import java.time.Instant;
import java.util.Map;

public record ValidationErrorResponse(
    Instant timestamp,
    int status,
    String error,
    String message,
    String path,
    Map<String,String> fieldError
){
}
