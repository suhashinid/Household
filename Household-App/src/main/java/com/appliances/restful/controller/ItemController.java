package com.appliances.restful.controller;

import com.appliances.restful.model.Item;
import com.appliances.restful.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author suhashini
 **/
@RestController
@RequestMapping("/item")
public class ItemController {

    final static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemService itemService;

    /**
     * Add new Item
     *
     * @param item
     * @return Added item
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
    	itemService.save(item);
        logger.debug("Added:: " + item);
        return new ResponseEntity<Item>(item, HttpStatus.CREATED);
    }

    /**
     * Edit Item
     *
     * @param item
     * @return updated item
     */
    @RequestMapping(path= "/editItem", method = RequestMethod.POST)
    public ResponseEntity<Item> editItem(@RequestBody Item item) {
    	itemService.save(item);
        logger.debug("Added:: " + item);
        return new ResponseEntity<Item>(item, HttpStatus.CREATED);
    }

    /**
     * Get All Items from repository/DB
     *
     * @return List of all Items
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAll();
        if (items.isEmpty()) {
            logger.debug("Items does not exists");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        logger.debug("Found " + items.size() + " Items");
        logger.debug(Arrays.toString(items.toArray()));
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
