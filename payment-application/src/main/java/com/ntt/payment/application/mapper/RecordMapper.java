package com.ntt.payment.application.mapper;

import com.ntt.payment.application.controller.model.RecordDTO;
import com.ntt.payment.domain.model.Record;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring", uses = {PaymentMapper.class})
public interface RecordMapper {

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "localDateTimeToString")
    RecordDTO toDTO(Record model);

    @IterableMapping(elementTargetType = RecordDTO.class)
    List<RecordDTO> toDTOs(List<Record> models);

    @Named("localDateTimeToString")
    default String localDateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }
}
