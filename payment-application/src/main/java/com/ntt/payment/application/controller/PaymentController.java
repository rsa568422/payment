package com.ntt.payment.application.controller;

import com.ntt.payment.application.controller.model.PaymentDTO;
import com.ntt.payment.application.controller.model.RecordDTO;
import com.ntt.payment.application.mapper.PaymentMapper;
import com.ntt.payment.application.mapper.RecordMapper;
import com.ntt.payment.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.ntt.payment.application.controller.api.PaymentApi;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PaymentController implements PaymentApi {

    private final PaymentService paymentService;

    private final PaymentMapper paymentMapper;

    private final RecordMapper recordMapper;

    @Override
    public ResponseEntity<UUID> save(PaymentDTO payment) {
        return ResponseEntity.ok(paymentService.save(paymentMapper.toModel(payment)));
    }

    @Override
    public ResponseEntity<List<RecordDTO>> findAll() {
        return ResponseEntity.ok(recordMapper.toDTOs(paymentService.findAll()));
    }
}
