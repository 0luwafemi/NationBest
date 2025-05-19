package com.femtech.client_service.client.customer;

import com.femtech.client_service.client.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public String createCustomer(CustomerRequest request) {
        var customer = this.repository.save(mapper.toCustomer(request));
        return customer.getId();
    }



    @Override
    public void UpdateCustomer(CustomerRequest request) {
        var customer = this.repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s",request.id())
        ));
mergeCustomer(customer,request);
this.repository.save(customer);

    }

    @Override
    public void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isAnyBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if(StringUtils.isAnyBlank(request.email())){
            customer.setEmail(request.email());
        }
        if (request.address() != null){
            customer.setAddress(request.address());
        }
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse findById(String id) {
        return this.repository.findById(id)
                .map(mapper::fromCustomer)
                .orElseThrow(()->new CustomerNotFoundException(String.format("No customer found with the proided ID %S", id)));
    }

    @Override
    public boolean existsById(String id) {
        return this.repository.findById(id)
                .isPresent();
    }

    @Override
    public void deleteCustomer(String id) {
        this.repository.deleteById(id);

    }
}
