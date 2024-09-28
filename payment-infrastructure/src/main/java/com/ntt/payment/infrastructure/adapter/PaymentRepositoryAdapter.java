package com.ntt.payment.infrastructure.adapter;

import com.ntt.payment.domain.model.Payment;
import com.ntt.payment.domain.model.Record;
import com.ntt.payment.domain.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PaymentRepositoryAdapter implements PaymentRepository {

    @Override
    public List<Record> findAll() {
        return List.of();
    }

    @Override
    public UUID save(Payment payment) {
        return UUID.randomUUID();
    }
}
