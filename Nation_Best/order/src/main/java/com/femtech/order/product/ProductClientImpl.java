package com.femtech.order.product;

import com.femtech.order.hander.BusinessException;

import java.util.List;

public interface ProductClientImpl {
    List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody) throws BusinessException;
}
