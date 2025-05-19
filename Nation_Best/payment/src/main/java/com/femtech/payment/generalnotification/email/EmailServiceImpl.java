package com.femtech.payment.generalnotification.email;

import com.femtech.payment.generalnotification.kafka.order.Product;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface EmailServiceImpl {

    void sendPaymentSuccessEmail(String destinationEmail, String customerName, BigDecimal amount, String orderReference) throws MessagingException;
    void sendOrderConfirmationEmail(String destinationEmail, String customerName, BigDecimal amount, String orderReference, List<Product> products
    ) throws MessagingException;
}
