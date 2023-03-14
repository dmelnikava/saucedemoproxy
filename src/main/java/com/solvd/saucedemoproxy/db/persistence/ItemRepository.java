package com.solvd.saucedemoproxy.db.persistence;


import com.solvd.saucedemoproxy.db.domain.Item;

import java.util.Optional;

public interface ItemRepository {

    void create(Item item);

    Optional<Item> read(Long id);

    void update(Item item);

    void delete(Long id);

}