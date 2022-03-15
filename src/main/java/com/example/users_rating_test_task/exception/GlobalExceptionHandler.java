package com.example.users_rating_test_task.exception;

import com.example.users_rating_test_task.api.dto.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IncorrectInputData.class)
    public ResponseEntity IncorrectInputDataErrorHandler(IncorrectInputData exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(exception.getMessage()));
    }
}
