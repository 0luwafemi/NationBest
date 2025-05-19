package com.femtech.payment.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated

public record Customer(
        String id,
        String firstName,
        String middleName,
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "customer email is not correctly formatted")
        String email
) {
}
