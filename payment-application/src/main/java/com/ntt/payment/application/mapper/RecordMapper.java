package com.ntt.payment.application.mapper;

import com.ntt.payment.application.controller.model.RecordDTO;
import com.ntt.payment.domain.model.Record;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PaymentMapper.class})
public interface RecordMapper {

    List<RecordDTO> toDTOs(List<Record> records);
}
