package com.femtech.payment.generalnotification.kafka;


import com.femtech.payment.generalnotification.email.EmailService;
import com.femtech.payment.generalnotification.kafka.order.OrderConfirmation;
import com.femtech.payment.generalnotification.kafka.payment.NotificationConsumerImpl;
import com.femtech.payment.generalnotification.kafka.payment.PaymentConfirmation;
import com.femtech.payment.generalnotification.notification.Notification;
import com.femtech.payment.generalnotification.notification.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.femtech.payment.generalnotification.notification.NotificationType.ORDER_CONFIRMATION;
import static com.femtech.payment.generalnotification.notification.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;


@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationsConsumer implements NotificationConsumerImpl {
    private final NotificationRepository repository;
    private final EmailService emailService;


    @Override
    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(format("Consume the message from payment-topic:: %s", paymentConfirmation));
        repository.save(
                Notification.builder()
                        .type(PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        var customerName = paymentConfirmation.customerLastName() + " " + paymentConfirmation.customerFirstname() + " " +paymentConfirmation.customerMiddleName();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );
    }

    @Override
    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
        repository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        var customerName = orderConfirmation.customer().firstName() + " " + orderConfirmation.customer().middleName() + " " + orderConfirmation.customer().lastName();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()

        );

    }
}
