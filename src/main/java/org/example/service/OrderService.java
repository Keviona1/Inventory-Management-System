package org.example.service;

import org.example.dto.OrderDto;
import org.example.dto.OrderItemsDto;
import org.example.entity.Order;

public interface OrderService {
    Order create(OrderDto orderDto);
}
