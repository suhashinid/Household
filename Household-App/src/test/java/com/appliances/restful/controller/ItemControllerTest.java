package com.appliances.restful.controller;

import com.appliances.restful.TestUtils;
import com.appliances.restful.model.Item;
import com.appliances.restful.service.ItemService;
import com.google.gson.reflect.TypeToken;
import com.appliances.restful.model.Item;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author suhashini
 * 
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ItemService itemService;

    private final String URL = "/item/";

    @Test
    public void testAddItem() throws Exception {

        // prepare data and mock's behaviour
    	Item itemStub = new Item(1, "S123490C", "Samsung", "S20","New",new Date("15-06-2020"));
      //  list.getItemList().add(new Item(2, "A123490D", "Apple", "IPhone 11","New",new Date("15-06-2020")));
       // list.getItemList().add(new Item(3, "S123890C", "Samsung", "S10","Old",new Date("15-06-2008")));

        when(itemService.save(any(Item.class))).thenReturn(itemStub);

        // execute
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8).content(TestUtils.objectToJson(itemStub))).andReturn();

        // verify
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.CREATED.value(), status, "Incorrect Response Status");

        // verify that service method was called once
        verify(itemService).save(any(Item.class));

        Item resultItem = TestUtils.jsonToObject(result.getResponse().getContentAsString(), Item.class);
        assertNotNull(resultItem);
        assertEquals(1l, resultItem.getId());

    }

    @Test
    public void testGetAllItems() throws Exception {

        // prepare data and mock's behaviour
        List<Item> itemList = buildItems();
        when(itemService.getAll()).thenReturn(itemList);

        // execute
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        // verify
        int status = result.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");

        // verify that service method was called once
        verify(itemService).getAll();

        // get the List<Item> from the Json response
        TypeToken<List<Item>> token = new TypeToken<List<Item>>() {
        };
        @SuppressWarnings("unchecked")
        List<Item> itemListResult = TestUtils.jsonToList(result.getResponse().getContentAsString(), token);

        assertNotNull(itemListResult, "Items not found");
        assertEquals(itemList.size(), itemListResult.size(), "Incorrect Items List");

    }

    private List<Item> buildItems() {
    	Item item1 = new Item(1, "S123490C", "Samsung", "S20","New",new Date("15-06-2020"));
    	Item item2 =new Item(2, "A123490D", "Apple", "IPhone 11","New",new Date("15-06-2020"));
       
        List<Item> itemList = Arrays.asList(item1, item2);
        return itemList;
    }

}
