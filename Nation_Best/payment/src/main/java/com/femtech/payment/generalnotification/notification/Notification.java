package com.femtech.payment.generalnotification.notification;

import com.femtech.payment.generalnotification.kafka.order.OrderConfirmation;
import com.femtech.payment.generalnotification.kafka.payment.PaymentConfirmation;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
//@Document
public class Notification {
    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;


}
