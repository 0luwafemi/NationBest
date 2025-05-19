package com.femtech.payment.generalnotification.kafka.payment;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerMiddleName,
        String customerLastName,
        String customerEmail

) {
}
