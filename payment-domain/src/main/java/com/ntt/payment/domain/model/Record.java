package com.ntt.payment.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@EqualsAndHashCode
public final class Record {

    @Setter
    private UUID id;

    private final Payment payment;

    private final LocalDateTime createdAt;

    public Record(UUID id, Payment payment, LocalDateTime createdAt) {
        if (Objects.isNull(payment))
            throw new VerifyError("Se debe proporcionar la información del pago");
        if (Objects.isNull(createdAt))
            throw new VerifyError("Se debe proporcionar una fecha de creación");
        this.id = id;
        this.payment = payment;
        this.createdAt = createdAt;
    }
}
