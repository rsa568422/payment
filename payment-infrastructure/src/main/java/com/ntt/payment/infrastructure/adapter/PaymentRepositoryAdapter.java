package com.ntt.payment.infrastructure.adapter;

import com.ntt.payment.domain.model.Payment;
import com.ntt.payment.domain.model.Record;
import com.ntt.payment.domain.repository.PaymentRepository;
import com.ntt.payment.infrastructure.mapper.PaymentEntityMapper;
import com.ntt.payment.infrastructure.mapper.RecordEntityMapper;
import com.ntt.payment.infrastructure.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;

    private final PaymentEntityMapper paymentMapper;

    private final RecordEntityMapper recordMapper;

    @Override
    public List<Record> findAll() {
        return recordMapper.toModels(paymentJpaRepository.findAll());
    }

    @Override
    public UUID save(Payment payment) {
        return paymentJpaRepository.save(paymentMapper.toEntity(payment)).getId();
    }
}
