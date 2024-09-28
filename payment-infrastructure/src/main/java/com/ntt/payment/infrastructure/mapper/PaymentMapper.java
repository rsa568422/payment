package com.ntt.payment.infrastructure.mapper;

import com.ntt.payment.domain.model.Payment;
import com.ntt.payment.infrastructure.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    PaymentEntity toEntity(Payment payment);
}
