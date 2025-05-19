package com.femtech.client_service.client.customer;


import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface CustomerService {
    String createCustomer ( CustomerRequest request);

    void UpdateCustomer(CustomerRequest request);
    void mergeCustomer(Customer customer, CustomerRequest request);
    List<CustomerResponse> findAllCustomers();
    CustomerResponse findById(String id);
    boolean existsById(String id);
    void deleteCustomer(String id);
    }


