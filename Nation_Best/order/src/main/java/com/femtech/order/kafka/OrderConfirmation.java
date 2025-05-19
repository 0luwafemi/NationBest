package com.femtech.order.kafka;

import com.femtech.order.customer.CustomerResponse;
import com.femtech.order.order.PaymentMethod;
import com.femtech.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
         String orderReference,
         BigDecimal totalAmount,
         PaymentMethod paymentMethod,
         CustomerResponse customer,
         List<PurchaseResponse>products


) {


}
