package com.ntt.payment.infrastructure.adapter;

import com.ntt.payment.infrastructure.Data;
import com.ntt.payment.infrastructure.mapper.PaymentEntityMapper;
import com.ntt.payment.infrastructure.mapper.RecordEntityMapper;
import com.ntt.payment.infrastructure.repository.PaymentJpaRepository;
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
class PaymentRepositoryAdapterTest {

    @InjectMocks
    private PaymentRepositoryAdapter paymentRepositoryAdapter;

    @Mock
    private PaymentJpaRepository paymentJpaRepository;

    @Mock
    private PaymentEntityMapper paymentEntityMapper;

    @Mock
    private RecordEntityMapper recordEntityMapper;

    @Test
    void findAll() {
        // given
        var payments = List.of(Data.SAVED_PAYMENT_ENTITY);
        var expected = List.of(Data.RECORD);

        when(paymentJpaRepository.findAll()).thenReturn(payments);
        when(recordEntityMapper.toModels(payments)).thenReturn(expected);

        // when
        var actual = paymentRepositoryAdapter.findAll();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertIterableEquals(expected, actual)
        );

        verify(paymentJpaRepository, times(1)).findAll();
        verify(recordEntityMapper, times(1)).toModels(payments);
        verifyNoMoreInteractions(paymentJpaRepository, paymentEntityMapper, recordEntityMapper);
    }

    @Test
    void save() {
        // given
        when(paymentEntityMapper.toEntity(Data.PAYMENT)).thenReturn(Data.PAYMENT_ENTITY);
        when(paymentJpaRepository.save(Data.PAYMENT_ENTITY)).thenReturn(Data.SAVED_PAYMENT_ENTITY);

        // when
        var actual = paymentRepositoryAdapter.save(Data.PAYMENT);

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(Data.ID, actual)
        );

        verify(paymentEntityMapper, times(1)).toEntity(Data.PAYMENT);
        verify(paymentJpaRepository, times(1)).save(Data.PAYMENT_ENTITY);
        verifyNoMoreInteractions(paymentJpaRepository, paymentEntityMapper, recordEntityMapper);
    }
}