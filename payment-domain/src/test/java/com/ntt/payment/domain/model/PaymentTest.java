package com.ntt.payment.domain.model;

import com.ntt.payment.domain.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {

    @Test
    void valid() {
        // given

        // when
        var actual = new Payment(Data.CARD_NUMBER, Data.AMOUNT_1, Data.DATE, Data.DESCRIPTION_1);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.CARD_NUMBER, actual.getCardNumber()),
                () -> assertEquals(Data.AMOUNT_1, actual.getAmount()),
                () -> assertEquals(Data.DATE, actual.getDate()),
                () -> assertEquals(Data.DESCRIPTION_1, actual.getDescription())
        );
    }

    @Test
    void setter() {
        // given
        var actual = new Payment(Data.CARD_NUMBER, Data.AMOUNT_1, Data.DATE, null);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.CARD_NUMBER, actual.getCardNumber()),
                () -> assertEquals(Data.AMOUNT_1, actual.getAmount()),
                () -> assertEquals(Data.DATE, actual.getDate()),
                () -> assertNull(actual.getDescription())
        );

        // when
        actual.setDescription(Data.DESCRIPTION_1);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.CARD_NUMBER, actual.getCardNumber()),
                () -> assertEquals(Data.AMOUNT_1, actual.getAmount()),
                () -> assertEquals(Data.DATE, actual.getDate()),
                () -> assertEquals(Data.DESCRIPTION_1, actual.getDescription()),
                () -> assertEquals(Data.PAYMENT_1, actual),
                () -> assertEquals(Data.PAYMENT_1.hashCode(), actual.hashCode())
        );
    }

    @ParameterizedTest
    @CsvSource({
            ", 150.35, 2024-09-28, El número de tarjeta de crédito es un campo obligatorio",
            "'   ', 150.35, 2024-09-28, El número de tarjeta de crédito es un campo obligatorio",
            "0000 0000 0000 0000, , 2024-09-28, El monto es obligatorio y debe ser mayor que cero",
            "0000 0000 0000 0000, 0.0, 2024-09-28, El monto es obligatorio y debe ser mayor que cero",
            "0000 0000 0000 0000, -0.01, 2024-09-28, El monto es obligatorio y debe ser mayor que cero",
            "0000 0000 0000 0000, 150.35, , La fecha de pago es un campo obligatorio",
            "0000 0000 0000 00000, 150.35, 2024-09-28, El número de tarjeta de crédito debe tener formato \"XXXX XXXX XXXX XXXX\"",
            "000 0000 0000 0000, 150.35, 2024-09-28, El número de tarjeta de crédito debe tener formato \"XXXX XXXX XXXX XXXX\"",
            "0000 0000 00o0 0000, 150.35, 2024-09-28, El número de tarjeta de crédito debe tener formato \"XXXX XXXX XXXX XXXX\"",
            "0000-0000-0000-0000, 150.35, 2024-09-28, El número de tarjeta de crédito debe tener formato \"XXXX XXXX XXXX XXXX\"",
    })
    void validations(String cardNumber, BigDecimal amount, LocalDate date, String message) {
        var error = assertThrows(VerifyError.class, () -> new Payment(cardNumber, amount, date, null));
        assertAll(
                () -> assertNotNull(error),
                () -> assertEquals(message, error.getMessage())
        );
    }
}