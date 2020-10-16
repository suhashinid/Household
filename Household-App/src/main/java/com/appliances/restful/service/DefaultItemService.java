package com.appliances.restful.service;

import com.appliances.restful.model.Item;
import com.appliances.restful.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suhashini
 * 
 */
@Service
public class DefaultItemService implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item entity) {
        return itemRepository.save(entity);
    }

   
    
    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
