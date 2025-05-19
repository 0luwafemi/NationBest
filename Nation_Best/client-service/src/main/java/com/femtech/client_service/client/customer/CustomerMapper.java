package com.femtech.client_service.client.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request){
        if (request == null){
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .middlename(request.middlename())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer){
        if (customer == null){
            return null;
        }
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getMiddlename(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
