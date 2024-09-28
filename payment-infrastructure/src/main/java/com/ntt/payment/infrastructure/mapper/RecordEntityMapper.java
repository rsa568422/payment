package com.ntt.payment.infrastructure.mapper;

import com.ntt.payment.domain.model.Record;
import com.ntt.payment.infrastructure.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PaymentEntityMapper.class})
public interface RecordEntityMapper {

    @Mapping(target = "payment", source = "payment")
    Record toModel(PaymentEntity payment);

    List<Record> toModels(List<PaymentEntity> payments);
}
