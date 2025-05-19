package com.femtech.order.payment;

import com.femtech.order.customer.CustomerResponse;
import com.femtech.order.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String OrderReference,
        CustomerResponse customer
) {
}
