package com.ntt.payment.domain.repository;

import com.ntt.payment.domain.model.Payment;
import com.ntt.payment.domain.model.Record;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository {

    List<Record> findAll();

    UUID save(Payment payment);
}
