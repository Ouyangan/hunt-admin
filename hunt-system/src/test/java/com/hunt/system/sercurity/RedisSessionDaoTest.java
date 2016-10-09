package com.hunt.system.sercurity;

import com.google.gson.Gson;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.SerializationUtils;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Author ouyangan
 * @Date 2016/10/9/9:21
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring.xml")
public class RedisSessionDaoTest {
    @Autowired
    private RedisTemplate<Serializable, Session> redisTemplate;


    @Test
    public void doCreate() throws Exception {
        Serializable sessionId = "shiro-session-" + UUID.randomUUID().toString();
        SimpleSession session = new SimpleSession();
        session.setId(sessionId);
        session.setAttribute("an", "ouyang");
        redisTemplate.opsForValue().set(sessionId, session);
    }

    @Test
    public void doReadSession() throws Exception {
        Session session = redisTemplate.opsForValue().get("shiro-session-8ce0d9cf-9eb7-4d80-b49f-ec390d43f51e");
        System.out.println(session.getAttribute("an"));
    }

    @Test
    public void update() throws Exception {
        SimpleSession session = new SimpleSession();
        session.setId("shiro-session-8ce0d9cf-9eb7-4d80-b49f-ec390d43f51e");
        session.setAttribute("an", "linpin");
        redisTemplate.opsForValue().set("shiro-session-8ce0d9cf-9eb7-4d80-b49f-ec390d43f51e", session);
    }

    @Test
    public void delete() throws Exception {
        redisTemplate.opsForValue().getOperations().delete("shiro-session-8ce0d9cf-9eb7-4d80-b49f-ec390d43f51e");
    }

    @Test
    public void getActiveSessions() throws Exception {

    }

}