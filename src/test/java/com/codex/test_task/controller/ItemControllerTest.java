package com.codex.test_task.controller;

import com.codex.test_task.entity.Item;
import com.codex.test_task.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private ItemService itemService;

    @Test
    public void getItem_test() throws Exception {
        final String expectedJson = "{id:602f347c-a79e-11eb-bcbc-0242ac130001, name:item1, price:'item1 description'}";

        RequestBuilder request = MockMvcRequestBuilders
                .get("/items/602f347c-a79e-11eb-bcbc-0242ac130001")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
                .andReturn();
    }
}
