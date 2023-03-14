package com.solvd.saucedemoproxy.db.service;

import com.solvd.saucedemoproxy.db.domain.Item;

public interface ItemService {

    Item create(Item item);

    Item read(Long id);

    void update(Item item);

    void delete(Long id);

}