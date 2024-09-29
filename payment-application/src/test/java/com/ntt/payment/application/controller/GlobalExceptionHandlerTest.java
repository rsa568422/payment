package com.ntt.payment.application.controller;

import com.ntt.payment.application.controller.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    private static final String MESSAGE = "test error";

    @Test
    void handleException() {
        // given
        var exception  = new VerifyError(MESSAGE);

        // when
        var actual = globalExceptionHandler.handleException(exception);

        // then
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
        var body = assertValidBodyClass(actual);
        assertAll(
                () -> assertEquals(VerifyError.class.getSimpleName(), body.getErrorClass()),
                () -> assertEquals(MESSAGE, body.getMessage()),
                () -> assertNotNull(body.getTime())
        );
    }

    private static ErrorDTO assertValidBodyClass(ResponseEntity<ErrorDTO> response) {
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertInstanceOf(ErrorDTO.class, response.getBody());
        return response.getBody();
    }
}