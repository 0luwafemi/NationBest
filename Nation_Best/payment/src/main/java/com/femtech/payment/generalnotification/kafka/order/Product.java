package com.femtech.payment.generalnotification.kafka.order;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;

public record Product(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity

) {
}
