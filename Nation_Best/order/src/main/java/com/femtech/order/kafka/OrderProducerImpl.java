package com.femtech.order.kafka;

public interface OrderProducerImpl {
    void SendOrderConfirmation(OrderConfirmation orderConfirmation);
}
