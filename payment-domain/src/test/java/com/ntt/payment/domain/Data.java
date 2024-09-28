package com.ntt.payment.domain;

import com.ntt.payment.domain.model.Payment;
import com.ntt.payment.domain.model.Record;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

public final class Data {

    private Data() {}

    public static final String CARD_NUMBER = "0000 0000 0000 0001";

    public static final LocalDate DATE = LocalDate.of(2024, Month.SEPTEMBER, 28);

    public static final LocalTime TIME_1 = LocalTime.of(12, 0, 0);

    public static final LocalTime TIME_2 = LocalTime.of(12, 1, 15);

    public static final UUID ID_1 = UUID.fromString("3f336588-2811-4b80-a156-fea55fad53c6");

    public static final UUID ID_2 = UUID.fromString("965e0d84-937c-4928-950e-fc295aeb496a");

    public static final BigDecimal AMOUNT_1 = BigDecimal.valueOf(56.35);

    public static final BigDecimal AMOUNT_2 = BigDecimal.valueOf(305.95);

    public static final String DESCRIPTION_1 = "Recibo de la luz";

    public static final String DESCRIPTION_2 = "Pago del IBI";

    public static final Payment PAYMENT_1 =
            Payment.builder().cardNumber(CARD_NUMBER).amount(AMOUNT_1).date(DATE).description(DESCRIPTION_1).build();

    public static final Payment PAYMENT_2 =
            Payment.builder().cardNumber(CARD_NUMBER).amount(AMOUNT_2).date(DATE).description(DESCRIPTION_2).build();

    public static final List<Record> RECORDS = List.of(
            Record.builder().id(ID_1).payment(PAYMENT_1).createdAt(LocalDateTime.of(DATE, TIME_1)).build(),
            Record.builder().id(ID_2).payment(PAYMENT_2).createdAt(LocalDateTime.of(DATE, TIME_2)).build()
    );
}
