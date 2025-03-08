package org.example.converter;

import org.example.dto.OrderDto;
import org.example.dto.OrderItemsDto;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.entity.OrderItems;
import org.example.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {    public static Order convertOrderToEntity(OrderDto orderDto) {
    Order order = new Order();
    order.setPaymentStatusEnum(orderDto.getPaymentStatusEnum());
    order.setClient(new Client(orderDto.getClientId()));
    order.setOrderItemsList(
            convertItemToEntity(orderDto.getOrderItemsDtoList()));
    return order;
}
    public static List<OrderItems> convertItemToEntity(List<OrderItemsDto> request) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        for (OrderItemsDto orderItemsDto: request) {
            OrderItems orderItem = new OrderItems();
            orderItem.setProduct(new Product(orderItemsDto.getProductId()));
            orderItem.setQuantity(orderItemsDto.getQuantity());
            orderItemsList.add(orderItem);
        }

        return orderItemsList;
    }
}
