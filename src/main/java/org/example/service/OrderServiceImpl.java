package org.example.service;

import org.example.config.HibernateConfig;
import org.example.converter.OrderConverter;
import org.example.dao.ProductDao;
import org.example.dao.ProductDaoImpl;
import org.example.dto.OrderDto;
import org.example.dto.OrderItemsDto;
import org.example.entity.Order;
import org.example.entity.Product;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService{
    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private ProductDao productDao = new ProductDaoImpl(sessionFactory);

    @Override
    public Order create(OrderDto orderDto) {
        List<Long> productIds = orderDto.getOrderItemsDtoList().stream().map(orderItemsDto -> orderItemsDto.getProductId()).collect(Collectors.toList());
        List<Product> products = productDao.findAllById(productIds);
        HashMap<Long, Double> mapPrice = new HashMap<>();
        for (Product product : products) {
            mapPrice.put(product.getId(), product.getPrice());
        }
        Order order = OrderConverter.convertOrderToEntity(orderDto);
        return null;
    }


}
