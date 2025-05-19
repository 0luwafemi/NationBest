package com.femtech.payment.notification;

import com.femtech.payment.payment.PaymentMethod;
import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerMiddlname,
        String customerLastname,
        String customerEmail


        ) {
}
