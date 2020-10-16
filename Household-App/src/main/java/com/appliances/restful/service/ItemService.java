package com.appliances.restful.service;

import com.appliances.restful.model.Item;

import java.util.List;

/**
 * @author suhashini
 * 
 */
public interface ItemService {
    Item save(Item item);
   
    List<Item> getAll();
}
