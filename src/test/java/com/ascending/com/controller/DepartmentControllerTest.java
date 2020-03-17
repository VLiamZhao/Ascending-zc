//package com.ascending.com.controller;
//
//import com.ascending.training.init.ApplicationBootstrap;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes= ApplicationBootstrap.class)
//@AutoConfigureMockMvc
//public class DepartmentControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private static String token;
//
//    @Before
//    public void init() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/auth")
//                .content("{" +
//                        " \"name\": \"dwang\"," +
//                        " \"password\": \"123456789\"," +
//                        " \"email\": \"dwang@training.ascendingdc.com\"" +
//                        "}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print()).andReturn();
//
//        token = result.getResponse().getContentAsString().replaceAll("Authorization:", "");
//        logger.info("Token: " + token);
//    }
//
//    @Test
//    public void getAllDepartments() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/departments").header("Authorization", token))
//                .andDo(MockMvcResultHandlers.print())
//                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//}