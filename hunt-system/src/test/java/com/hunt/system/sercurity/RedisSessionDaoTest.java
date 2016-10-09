package com.hunt.system.sercurity;

import org.apache.shiro.session.mgt.SimpleSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.SerializationUtils;
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
    private RedisSessionDao redisSessionDao;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisTemplate redisTemplate1;
    @Test
    public void doCreate() throws Exception {
        Serializable sessionId = "shiro-session-" + UUID.randomUUID().toString();
        SimpleSession session = new SimpleSession();
        session.setId(sessionId);
        session.setAttribute("an","ouyang");
        redisTemplate.opsForValue().set(sessionId.toString(),session);

    }

    @Test
    public void doReadSession() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getActiveSessions() throws Exception {

    }

}