package com.femtech.payment.generalnotification.kafka.order;

public record Customer(
        String id,
        String firstName,
        String middleName,
        String lastName,
        String email
) {
}


