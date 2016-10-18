package com.hunt.system.security;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author ouyangan
 * @Date 2016/10/8/11:25
 * @Description
 */
public class RedisSessionDao extends AbstractSessionDAO {

    private static final String sessionIdPrefix = "shiro-session-";
    @Autowired
    private RedisTemplate<Serializable, Session> redisTemplate;

    private static final long timeout = 3600 * 24 * 30 * 1000;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = sessionIdPrefix + UUID.randomUUID().toString();
        assignSessionId(session, sessionId);
        redisTemplate.opsForValue().set(sessionId, session);
        return sessionId;
    }


    @Override
    protected Session doReadSession(Serializable sessionId) {
        return redisTemplate.opsForValue().get(sessionId);
    }


    @Override
    public void update(Session session) throws UnknownSessionException {
        redisTemplate.opsForValue().set(session.getId(), session);
    }

    @Override
    public void delete(Session session) {
        redisTemplate.opsForValue().getOperations().delete(session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Serializable> keys = redisTemplate.keys(sessionIdPrefix + "*");
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        List<Session> sessions = redisTemplate.opsForValue().multiGet(keys);
        return Collections.unmodifiableCollection(sessions);
    }
}
