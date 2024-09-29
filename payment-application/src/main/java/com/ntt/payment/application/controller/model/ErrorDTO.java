package com.ntt.payment.application.controller.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ErrorDTO {

    private final String errorClass;

    private final String message;

    private final LocalDateTime time = LocalDateTime.now();
}
