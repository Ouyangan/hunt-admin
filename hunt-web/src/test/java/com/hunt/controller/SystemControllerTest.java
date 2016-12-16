package com.hunt.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author ouyangan
 * @Date 2016/10/20/16:28
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "classpath:src/main/webapp")
@ContextConfiguration({"classpath:spring.xml", "classpath:spring/spring-mvc.xml"})
@Transactional
public class SystemControllerTest {
    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void toIndex() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//                .get("/system/index")
//        )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
    }

    @Test
    public void login() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//                .post("/system/login")
//                .param("loginName", "admin")
//                .param("password", "111111")
//                .param("platform", "1")
//        )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();

    }

    @Test
    public void logout() throws Exception {

    }

    @Test
    public void forceLogout() throws Exception {

    }

    @Test
    public void startCaptcha() throws Exception {

    }

}