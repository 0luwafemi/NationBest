package com.femtech.client_service.client.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String Lastname,
        String middlename,
        String email,
        Address address


) {
}
