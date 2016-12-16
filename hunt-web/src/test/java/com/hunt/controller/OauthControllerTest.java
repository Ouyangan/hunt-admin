package com.hunt.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import com.hunt.util.SystemConstant;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: ouyangan
 * @Date : 2016/10/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "classpath:src/main/webapp")
@ContextConfiguration({"classpath:spring.xml", "classpath:spring/spring-mvc.xml"})
@Transactional
public class OauthControllerTest {

    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void github() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("https://github.com/login/oauth/authorize")
                .param("client_id", SystemConstant.github_client_id)
                .param("state", "test github oauth")
                .param("redirect_uri", SystemConstant.github_oauth_url)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}