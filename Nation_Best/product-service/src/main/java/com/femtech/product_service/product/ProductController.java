package com.femtech.product_service.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/api/v1/products")
//@RequiredArgsConstructor
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path= "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest request){
        return ResponseEntity.ok(service.createProduct(request));
    }
    @PostMapping("/purchase")
    public ResponseEntity<ArrayList<Object>> purchaseProducts(@RequestBody List<ProductPurchaseRequest>request){
        return ResponseEntity.ok(service.purchaseProducts(request));
    }
    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId){
        return ResponseEntity.ok(service.findById(productId));
    }
    public ResponseEntity<List<ProductResponse>>findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
