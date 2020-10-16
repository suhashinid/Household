package com.appliances.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appliances.restful.model.Item;

/**
 * 
 * @author suhashini
 *  
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
