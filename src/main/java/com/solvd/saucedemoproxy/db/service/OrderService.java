package com.solvd.saucedemoproxy.db.service;

import com.solvd.saucedemoproxy.db.domain.Order;

import java.util.List;

public interface OrderService {

    Order create(Long userId, Order order);

    List<Order> read(Long userId, Long orderId);

    void update(Order order);

    void delete(Long id);

}