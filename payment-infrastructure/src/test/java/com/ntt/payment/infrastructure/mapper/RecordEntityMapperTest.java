package com.ntt.payment.infrastructure.mapper;

import com.ntt.payment.infrastructure.Data;
import com.ntt.payment.infrastructure.configuration.MapperTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ContextConfiguration(classes = {MapperTestConfig.class})
class RecordEntityMapperTest {

    @Autowired
    private RecordEntityMapper recordEntityMapper;

    @Test
    void toModel() {
        // given

        // when
        var actual = recordEntityMapper.toModel(Data.SAVED_PAYMENT_ENTITY);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ID, actual.getId()),
                () -> assertEquals(Data.PAYMENT, actual.getPayment()),
                () -> assertEquals(Data.CREATED_AT, actual.getCreatedAt())
        );
    }

    @Test
    void toModels() {
        // given
        var payments = List.of(Data.SAVED_PAYMENT_ENTITY);

        // when
        var actual = recordEntityMapper.toModels(payments);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(1, actual.size()),
                () -> assertIterableEquals(List.of(Data.RECORD), actual)
        );
    }

    @Test
    void mappingNull() {
        assertAll(
                () -> assertNull(recordEntityMapper.toModel(null)),
                () -> assertNull(recordEntityMapper.toModels(null))
        );
    }
}