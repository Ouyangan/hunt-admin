package com.hunt.system.security.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.*;

/**
 * @Author ouyangan
 * @Date 2016/10/9/13:55
 * @Description
 */

public class RedisCache<K, V> implements Cache<K, V>,Serializable {

    private static final String shiro_cache_prefix = "shiro-cache-";
    private static final String shiro_cache_prefix_keys = "shiro-cache-*";
    private static Logger log = LoggerFactory.getLogger(RedisCache.class);

    @Autowired
    private RedisTemplate<K, V> redisTemplate;

    private String name;

    private final Map<K, V> map;

    public RedisCache(String name, Map<K, V> backingMap) {
        if (name == null) {
            throw new IllegalArgumentException("Cache name cannot be null.");
        }
        if (backingMap == null) {
            throw new IllegalArgumentException("Backing map cannot be null.");
        }
        this.name = name;
        this.map = backingMap;
    }

    @Override
    public V get(K key) throws CacheException {
        log.debug("redis cache get :{}", key.toString());
        return redisTemplate.opsForValue().get(shiro_cache_prefix + key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        log.debug("redis cache put :{}", key.toString());
        redisTemplate.opsForValue().set((K) (shiro_cache_prefix + key), value);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        log.debug("redis cache remove :{}", key.toString());
        V value = redisTemplate.opsForValue().get(shiro_cache_prefix + key);
        redisTemplate.delete(key);
        return value;
    }

    @Override
    public void clear() throws CacheException {
        log.debug("redis cache clear");
        Set<K> keys = redisTemplate.keys((K) shiro_cache_prefix_keys);
        redisTemplate.delete(keys);
    }

    @Override
    public int size() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_prefix_keys);
        log.debug("redis cache size :{}", keys.size());
        return keys.size();
    }

    @Override
    public Set<K> keys() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_prefix_keys);
        log.debug("redis cache keys");
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_prefix_keys);
        log.debug("redis cache values");
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        List<V> vs = redisTemplate.opsForValue().multiGet(keys);

        return Collections.unmodifiableCollection(vs);
    }


}
