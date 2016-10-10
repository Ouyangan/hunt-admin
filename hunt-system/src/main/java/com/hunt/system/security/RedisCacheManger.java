package com.hunt.system.security;

import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author ouyangan
 * @Date 2016/10/9/14:13
 * @Description
 */
public class RedisCacheManger implements CacheManager, Initializable, Destroyable {

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return null;
    }

    /**
     * Called when this object is being destroyed, allowing any necessary cleanup of internal resources.
     *
     * @throws Exception if an exception occurs during object destruction.
     */
    @Override
    public void destroy() throws Exception {

    }

    /**
     * Initializes this object.
     *
     * @throws ShiroException if an exception occurs during initialization.
     */
    @Override
    public void init() throws ShiroException {

    }
}
