package com.femtech.order.orderline;

import com.femtech.order.order.Order;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request){
        return OrderLine.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }
    public OrderLineResponse toOrderLineResponse(OrderLine orderLine){
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
