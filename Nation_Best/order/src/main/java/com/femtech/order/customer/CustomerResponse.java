package com.femtech.order.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String email
) {
}
