package com.solvd.saucedemoproxy.db.service.impl;

import com.solvd.saucedemoproxy.db.domain.Item;
import com.solvd.saucedemoproxy.db.domain.exception.QueryException;
import com.solvd.saucedemoproxy.db.persistence.ItemRepository;
import com.solvd.saucedemoproxy.db.persistence.impl.ItemMapperImpl;
import com.solvd.saucedemoproxy.db.service.ItemService;

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl() {
        this.itemRepository = new ItemMapperImpl();
    }

    @Override
    public Item create(Item item) {
        item.setId(null);
        itemRepository.create(item);
        return item;
    }

    @Override
    public Item read(Long id) {
        return itemRepository.read(id)
                .orElseThrow(() -> new QueryException("No items found"));
    }

    @Override
    public void update(Item item) {
        itemRepository.update(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(id);
    }
}
