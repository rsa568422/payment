package com.ntt.payment.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@EqualsAndHashCode
public final class Payment {

    private final String cardNumber;

    private final BigDecimal amount;

    private final LocalDate date;

    @Setter
    private String description;

    public Payment(String cardNumber, BigDecimal amount, LocalDate date, String description) {
        if (Objects.isNull(cardNumber) || cardNumber.isBlank())
            throw new VerifyError("El número de tarjeta de crédito es un campo obligatorio");
        if (Objects.isNull(amount) || (BigDecimal.ZERO.compareTo(amount) >= 0))
            throw new VerifyError("El monto es obligatorio y debe ser mayor que cero");
        if (Objects.isNull(date))
            throw new VerifyError("La fecha de pago es un campo obligatorio");
        if (!Pattern.matches("^\\d{4} \\d{4} \\d{4} \\d{4}$", cardNumber))
            throw new VerifyError("El número de tarjeta de crédito debe tener formato \"XXXX XXXX XXXX XXXX\"");
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
}
