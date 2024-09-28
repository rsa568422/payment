package com.ntt.payment.application.controller;

import com.ntt.payment.application.Data;
import com.ntt.payment.application.mapper.PaymentMapper;
import com.ntt.payment.application.mapper.RecordMapper;
import com.ntt.payment.domain.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private PaymentService paymentService;

    @Mock
    private PaymentMapper paymentMapper;

    @Mock
    private RecordMapper recordMapper;

    @Test
    void save() {
        // given
        var payment = Data.PAYMENT_DTO();

        when(paymentMapper.toModel(payment)).thenReturn(Data.PAYMENT);
        when(paymentService.save(Data.PAYMENT)).thenReturn(Data.ID);

        // when
        var actual = paymentController.save(payment);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(HttpStatus.OK, actual.getStatusCode()),
                () -> assertNotNull(actual.getBody()),
                () -> assertEquals(Data.ID, actual.getBody())
        );

        verify(paymentMapper, times(1)).toModel(payment);
        verify(paymentService, times(1)).save(Data.PAYMENT);
        verifyNoMoreInteractions(paymentService, paymentMapper, recordMapper);
    }

    @Test
    void findAll() {
        // given
        var records = List.of(Data.RECORD);
        var expected = List.of(Data.RECORD_DTO());

        when(paymentService.findAll()).thenReturn(records);
        when(recordMapper.toDTOs(records)).thenReturn(expected);

        // when
        var actual = paymentController.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(HttpStatus.OK, actual.getStatusCode()),
                () -> assertNotNull(actual.getBody()),
                () -> assertIterableEquals(expected, actual.getBody())
        );

        verify(paymentService, times(1)).findAll();
        verify(recordMapper, times(1)).toDTOs(records);
        verifyNoMoreInteractions(paymentService, paymentMapper, recordMapper);
    }
}