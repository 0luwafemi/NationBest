package com.femtech.product_service.product;

import java.util.ArrayList;
import java.util.List;

public interface ProductServiceImpl {

    Integer createProduct(ProductRequest request);
    ProductResponse findById(Integer id);

    List<ProductResponse> findAll();

    ArrayList<Object> purchaseProducts(List<ProductPurchaseRequest> requests);


}
