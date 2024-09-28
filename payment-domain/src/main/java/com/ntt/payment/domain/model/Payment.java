package com.ntt.payment.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Payment {

    private String cardNumber;

    private BigDecimal amount;

    private LocalDate date;

    private String description;
}
