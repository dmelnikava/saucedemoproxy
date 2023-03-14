package com.solvd.saucedemoproxy.db.persistence;

import com.solvd.saucedemoproxy.db.domain.Item;
import com.solvd.saucedemoproxy.db.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderRepository {

    void create(@Param("userId") Long userId, @Param("order") Order order);

    void createItemConnection(Order order, Item item);

    List<Order> read(@Param("userId") Long userId, @Param("orderId") Long orderId);

    void update(Order order);

    void delete(Long id);

}