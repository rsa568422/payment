package com.ntt.payment.application.mapper;

import com.ntt.payment.application.controller.model.PaymentDTO;
import com.ntt.payment.domain.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO toDTO(Payment payment);

    Payment toModel(PaymentDTO payment);
}
