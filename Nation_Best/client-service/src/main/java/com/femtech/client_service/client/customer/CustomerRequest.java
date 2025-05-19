package com.femtech.client_service.client.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer firstname is required")
        String firstname,
        @NotNull(message = "Customer middlename is required")
        String middlename,
        @NotNull(message = "Customer lastname is required")
        String lastname,
        @NotNull(message = "Customer Email is required")
        @Email(message = "Customer Email is not a valid email address")
        String email,
        @NotNull(message = "Customer address is required")
        Address address
) {
}
