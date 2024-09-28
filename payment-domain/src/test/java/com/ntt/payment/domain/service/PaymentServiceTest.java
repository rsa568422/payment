package com.ntt.payment.domain.service;

import com.ntt.payment.domain.Data;
import com.ntt.payment.domain.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    private PaymentService paymentService;

    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        paymentRepository = Mockito.mock(PaymentRepository.class);
        paymentService = new TestPaymentService(paymentRepository);
    }

    @Test
    void findAll() {
        // given
        when(paymentRepository.findAll()).thenReturn(Data.RECORDS);

        // when
        var actual = paymentService.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(2, actual.size()),
                () -> assertIterableEquals(Data.RECORDS, actual)
        );

        verify(paymentRepository, times(1)).findAll();
        verifyNoMoreInteractions(paymentRepository);
    }

    @Test
    void save() {
        // given
        when(paymentRepository.save(Data.PAYMENT_1)).thenReturn(Data.ID_1);

        // when
        var actual = paymentService.save(Data.PAYMENT_1);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ID_1, actual)
        );

        verify(paymentRepository, times(1)).save(Data.PAYMENT_1);
        verifyNoMoreInteractions(paymentRepository);
    }

    private static class TestPaymentService extends PaymentService {
        public TestPaymentService(PaymentRepository paymentRepository) {
            super(paymentRepository);
        }
    }
}