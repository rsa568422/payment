package com.ntt.payment.application.service;

import com.ntt.payment.domain.repository.PaymentRepository;
import com.ntt.payment.domain.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentSpringService extends PaymentService {

    public PaymentSpringService(PaymentRepository paymentRepository) {
        super(paymentRepository);
    }
}
