package com.ntt.payment.domain.model;

import com.ntt.payment.domain.Data;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RecordTest {

    @Test
    void valid() {
        // given
        var createdAt = LocalDateTime.of(Data.DATE, Data.TIME_1);

        // when
        var actual = new Record(null, Data.PAYMENT_1, createdAt);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertNull(actual.getId()),
                () -> assertEquals(createdAt, actual.getCreatedAt())
        );
    }

    @Test
    void setter() {
        // given
        var expected = Data.RECORDS.get(0);
        var createdAt = LocalDateTime.of(Data.DATE, Data.TIME_1);
        var actual = new Record(null, Data.PAYMENT_1, createdAt);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertNull(actual.getId()),
                () -> assertEquals(Data.PAYMENT_1, actual.getPayment()),
                () -> assertEquals(createdAt, actual.getCreatedAt())
        );

        // when
        actual.setId(Data.ID_1);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ID_1, actual.getId()),
                () -> assertEquals(Data.PAYMENT_1, actual.getPayment()),
                () -> assertEquals(createdAt, actual.getCreatedAt()),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.hashCode(), actual.hashCode())
        );
    }

    @Test
    void paymentValidation() {
        // given
        var createdAt = LocalDateTime.now();

        // when
        var error = assertThrows(VerifyError.class, () -> new Record(null, null, createdAt));

        // then
        assertEquals("Se debe proporcionar la información del pago", error.getMessage());
    }

    @Test
    void createdAtValidation() {
        // given

        // when
        var error = assertThrows(VerifyError.class, () -> new Record(null, Data.PAYMENT_1, null));

        // then
        assertEquals("Se debe proporcionar una fecha de creación", error.getMessage());
    }
}