package com.hunt.system.sercurity;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @Author ouyangan
 * @Date 2016/10/9/13:55
 * @Description
 */

public class RedisCache<K, V> implements Cache<K, V> {

    private static final String shiro_cache_prefix = "shiro-cache-";
    private static final String shiro_cache_keys = "shiro-cache-keys";
    private static final String shiro_cache_all_pattern = shiro_cache_prefix + "*";

    @Autowired
    private RedisTemplate<K, V> redisTemplate;

    @Override
    public V get(K key) throws CacheException {
        V v = redisTemplate.opsForValue().get(shiro_cache_prefix + key);
        return v;
    }

    @Override
    public V put(K key, V value) throws CacheException {
        redisTemplate.opsForValue().set((K) (shiro_cache_prefix + key), value);
        return null;
    }

    @Override
    public V remove(K key) throws CacheException {
        redisTemplate.opsForValue().getOperations().delete(key);
        return null;
    }

    @Override
    public void clear() throws CacheException {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_all_pattern);
        redisTemplate.opsForValue().getOperations().delete(keys);
    }

    @Override
    public int size() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_all_pattern);
        return keys.size();
    }

    @Override
    public Set<K> keys() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_all_pattern);
        if (keys.isEmpty()) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(keys);
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_all_pattern);
        if (keys.isEmpty()) {
            return Collections.emptySet();
        }
        List<V> vs = redisTemplate.opsForValue().multiGet(keys);
        return Collections.unmodifiableCollection(vs);
    }
}
