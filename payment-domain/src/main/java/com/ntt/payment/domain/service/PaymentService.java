package com.ntt.payment.domain.service;

import com.ntt.payment.domain.model.Payment;
import com.ntt.payment.domain.model.Record;
import com.ntt.payment.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class PaymentService {

    private final PaymentRepository paymentRepository;

    public List<Record> findAll() {
        return paymentRepository.findAll();
    }

    public UUID save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
