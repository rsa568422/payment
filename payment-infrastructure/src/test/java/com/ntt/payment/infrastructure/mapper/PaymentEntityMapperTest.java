package com.ntt.payment.infrastructure.mapper;

import com.ntt.payment.infrastructure.Data;
import com.ntt.payment.infrastructure.configuration.MapperTestConfig;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ContextConfiguration(classes = {MapperTestConfig.class})
class PaymentEntityMapperTest {

    @Autowired
    private PaymentEntityMapper paymentEntityMapper;

    @Test
    void toModel() {
        // given

        // when
        var actual = paymentEntityMapper.toModel(Data.SAVED_PAYMENT_ENTITY);

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
    void toEntity() {
        // given
        var now = LocalDateTime.of(Data.DATE, LocalTime.MAX);

        try (MockedStatic<LocalDateTime> localDateTimeMockedStatic = Mockito.mockStatic(LocalDateTime.class)) {
            localDateTimeMockedStatic.when(LocalDateTime::now).thenReturn(now);

            // when
            var actual = paymentEntityMapper.toEntity(Data.PAYMENT);

            // then
            assertAll(
                    () -> assertNotNull(actual),
                    () -> assertNull(actual.getId()),
                    () -> assertEquals(Data.CARD_NUMBER, actual.getCardNumber()),
                    () -> assertEquals(Data.AMOUNT, actual.getAmount()),
                    () -> assertEquals(Data.DATE, actual.getDate()),
                    () -> assertEquals(Data.DESCRIPTION, actual.getDescription()),
                    () -> assertEquals(now, actual.getCreatedAt())
            );
        }
    }

    @Test
    void mappingNull() {
        assertAll(
                () -> assertNull(paymentEntityMapper.toModel(null)),
                () -> assertNull(paymentEntityMapper.toEntity(null))
        );
    }
}