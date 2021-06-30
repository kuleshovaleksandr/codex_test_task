package com.codex.test_task.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebAppConfiguration
public class ItemControllerTest {

//    private MockMvc mockMvc;
//
//    @Test
//    public void getItem_test() throws Exception {
//        final String expectedJson = "{\n" +
//                "  \"id\": \"602f347c-a79e-11eb-bcbc-0242ac130001\",\n" +
//                "  \"name\": \"item1\",\n" +
//                "  \"description\": \"item1 description\",\n" +
//                "  \"tags\": [\n" +
//                "    {\n" +
//                "      \"name\": \"black\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"camera\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"canon\"\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .get("/items/602f347c-a79e-11eb-bcbc-0242ac130001")
//                .accept(MediaType.APPLICATION_JSON);
//
//        this.mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
//                .andReturn();
//    }
//
//    @Test
//    public void createItem_test() throws Exception {
//        RequestBuilder request = post("/items")
//                .content("{\n" +
//                        "  \"description\": \"string\",\n" +
//                        "  \"name\": \"string\"\n" +
//                        "}")
//                .accept(MediaType.APPLICATION_JSON);
//
//        this.mockMvc.perform(request)
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(content().json("{\n" +
//                        "  \"id\": \"e285a34b-f007-408c-9cf3-8cc9e2b72a18\",\n" +
//                        "  \"name\": \"string\",\n" +
//                        "  \"description\": \"string\",\n" +
//                        "  \"tags\": null\n" +
//                        "}"));
//    }
}
