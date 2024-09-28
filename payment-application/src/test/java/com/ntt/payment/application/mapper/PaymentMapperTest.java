package com.ntt.payment.application.mapper;

import com.ntt.payment.application.Data;
import com.ntt.payment.application.configuration.MapperTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ContextConfiguration(classes = {MapperTestConfig.class})
class PaymentMapperTest {

    @Autowired
    private PaymentMapper paymentMapper;

    @Test
    void toDTO() {
        // given
        var amount = 56.35;
        var date = "2024-09-28";

        // when
        var actual = paymentMapper.toDTO(Data.PAYMENT);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.CARD_NUMBER, actual.getCardNumber()),
                () -> assertEquals(amount, actual.getAmount()),
                () -> assertEquals(date, actual.getDate()),
                () -> assertEquals(Data.DESCRIPTION, actual.getDescription())
        );
    }

    @Test
    void toModel() {
        // given
        var payment = Data.PAYMENT_DTO();

        // when
        var actual = paymentMapper.toModel(payment);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.CARD_NUMBER, actual.getCardNumber()),
                () -> assertEquals(Data.AMOUNT, actual.getAmount()),
                () -> assertEquals(Data.DATE, actual.getDate()),
                () -> assertEquals(Data.DESCRIPTION, actual.getDescription())
        );
    }

    @Test
    void mappingNull() {
        assertAll(
                () -> assertNull(paymentMapper.toDTO(null)),
                () -> assertNull(paymentMapper.toModel(null))
        );
    }
}