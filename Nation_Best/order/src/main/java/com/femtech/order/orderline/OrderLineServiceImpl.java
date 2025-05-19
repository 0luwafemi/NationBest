package com.femtech.order.orderline;

import java.util.List;

public interface OrderLineServiceImpl {
    Integer SaveOrderLine(OrderLineRequest request);
    List<OrderLineResponse> FindAllByOrderId(Integer orderId);
}
