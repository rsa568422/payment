package com.ntt.payment.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Record {

    private UUID id;

    private Payment payment;

    private LocalDateTime createdAt;
}
