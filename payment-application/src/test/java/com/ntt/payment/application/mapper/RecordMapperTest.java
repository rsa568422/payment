package com.ntt.payment.application.mapper;

import com.ntt.payment.application.Data;
import com.ntt.payment.application.configuration.MapperTestConfig;
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
class RecordMapperTest {

    @Autowired
    private RecordMapper recordMapper;

    @Test
    void toDTO() {
        // given
        var expected = Data.RECORD_DTO();

        // when
        var actual = recordMapper.toDTO(Data.RECORD);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void toDTOs() {
        // given
        var expected = List.of(Data.RECORD_DTO());

        // when
        var actual = recordMapper.toDTOs(List.of(Data.RECORD));

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(expected, actual)
        );
    }

    @Test
    void localDateTimeToString() {
        // given
        var expected = "2024-09-28 12:00:00";

        // when
        var actual = recordMapper.localDateTimeToString(Data.CREATED_AT);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    void mappingNull() {
        assertAll(
                () -> assertNull(recordMapper.toDTO(null)),
                () -> assertNull(recordMapper.toDTOs(null))
        );
    }
}