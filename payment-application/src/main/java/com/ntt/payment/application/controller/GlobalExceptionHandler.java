package com.ntt.payment.application.controller;

import com.ntt.payment.application.controller.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VerifyError.class)
    public ResponseEntity<ErrorDTO> handleException(VerifyError exception) {
        return buildErrorResponse(exception);
    }

    private static ResponseEntity<ErrorDTO> buildErrorResponse(VerifyError exception) {
        return new ResponseEntity<>(
                new ErrorDTO(exception.getClass().getSimpleName(), exception.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
