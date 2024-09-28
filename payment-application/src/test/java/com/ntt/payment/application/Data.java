package com.ntt.payment.application;

import com.ntt.payment.application.controller.model.PaymentDTO;
import com.ntt.payment.application.controller.model.RecordDTO;
import com.ntt.payment.domain.model.Payment;
import com.ntt.payment.domain.model.Record;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.UUID;

public final class Data {

    private Data() {}

    public static final UUID ID = UUID.fromString("3f336588-2811-4b80-a156-fea55fad53c6");

    public static final String CARD_NUMBER = "0000 0000 0000 0001";

    public static final LocalDate DATE = LocalDate.of(2024, Month.SEPTEMBER, 28);

    public static final LocalTime TIME = LocalTime.of(12, 0, 0);

    public static final BigDecimal AMOUNT = BigDecimal.valueOf(56.35);

    public static final String DESCRIPTION = "Recibo de la luz";

    public static final LocalDateTime CREATED_AT = LocalDateTime.of(DATE, TIME);

    public static final Payment PAYMENT =
            Payment.builder().cardNumber(CARD_NUMBER).amount(AMOUNT).date(DATE).description(DESCRIPTION).build();

    public static final Record RECORD = Record.builder().id(ID).payment(PAYMENT).createdAt(CREATED_AT).build();

    public static PaymentDTO PAYMENT_DTO() {
        var dto = new PaymentDTO();
        dto.setCardNumber(CARD_NUMBER);
        dto.setAmount(AMOUNT.doubleValue());
        dto.setDate("2024-09-28");
        dto.setDescription(DESCRIPTION);
        return dto;
    }

    public static RecordDTO RECORD_DTO() {
        var dto = new RecordDTO();
        dto.setId(ID);
        dto.setPayment(PAYMENT_DTO());
        dto.setCreatedAt("2024-09-28 12:00:00");
        return dto;
    }
}
