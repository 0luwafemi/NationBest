package com.femtech.payment.generalnotification.kafka.payment;

import com.femtech.payment.generalnotification.kafka.order.OrderConfirmation;
import jakarta.mail.MessagingException;

public interface NotificationConsumerImpl {
    void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException;
    void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException;


}
