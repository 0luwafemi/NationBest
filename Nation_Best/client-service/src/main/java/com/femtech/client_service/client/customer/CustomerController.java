package com.femtech.client_service.client.customer;

import jakarta.validation.Valid;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    @PostMapping("/create-customer")
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok(this.service.createCustomer(request));
    }

    @PutMapping("/update-customer")
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        this.service.UpdateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(this.service.findAllCustomers());
    }
    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean>existsById(
            @PathVariable("customer_id") String customerId
    ){
        return ResponseEntity.ok(this.service.existsById(customerId));
    }
    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse>findById(
            @PathVariable("customer-id") String customerId

    ){
        return  ResponseEntity.ok(this.service.findById(customerId));

    }
    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("customer-id") String customerId
    ){
        this.service.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }

}
