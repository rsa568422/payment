package com.ntt.payment.application.service;

import com.ntt.payment.application.Data;
import com.ntt.payment.domain.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
class PaymentSpringServiceTest {

    @InjectMocks
    private PaymentSpringService paymentSpringService;

    @Mock
    private PaymentRepository paymentRepository;

    @Test
    void findAll() {
        // given
        var expected = List.of(Data.RECORD);

        when(paymentRepository.findAll()).thenReturn(expected);

        // when
        var actual = paymentSpringService.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(expected, actual)
        );

        verify(paymentRepository, times(1)).findAll();
        verifyNoMoreInteractions(paymentRepository);
    }

    @Test
    void save() {
        // given
        when(paymentRepository.save(Data.PAYMENT)).thenReturn(Data.ID);

        // when
        var actual = paymentSpringService.save(Data.PAYMENT);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ID, actual)
        );

        verify(paymentRepository, times(1)).save(Data.PAYMENT);
        verifyNoMoreInteractions(paymentRepository);
    }
}