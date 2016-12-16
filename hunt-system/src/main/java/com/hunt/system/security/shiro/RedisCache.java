package com.hunt.system.security.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.hunt.util.SystemConstant;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author ouyangan
 * @Date 2016/10/9/13:55
 * @Description Cache   redis实现
 */
public class RedisCache<K, V> implements Cache<K, V>, Serializable {
    public static final String shiro_cache_prefix = "shiro-cache-";
    public static final String shiro_cache_prefix_keys = "shiro-cache-*";
    private static final long timeout = 2592000;
    private transient static Logger log = LoggerFactory.getLogger(RedisCache.class);

    private transient RedisTemplate<K, V> redisTemplate;

    public RedisCache(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public RedisCache() {
    }

    @Override
    public V get(K key) throws CacheException {
        log.debug("根据key:{}从redis获取对象", key);
        log.debug("redisTemplate : {}", redisTemplate);
        return redisTemplate.opsForValue().get(shiro_cache_prefix + key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        log.debug("根据key:{}从redis删除对象", key);
        redisTemplate.opsForValue().set((K) (shiro_cache_prefix + key), value, timeout, TimeUnit.SECONDS);
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
        log.debug("清除redis所有缓存对象");
        Set<K> keys = redisTemplate.keys((K) shiro_cache_prefix_keys);
        redisTemplate.delete(keys);
    }

    @Override
    public int size() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_prefix_keys);
        log.debug("获取redis缓存对象数量:{}", keys.size());
        return keys.size();
    }

    @Override
    public Set<K> keys() {
        Set<K> keys = redisTemplate.keys((K)shiro_cache_prefix_keys);
        log.debug("获取所有缓存对象的key");
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<K> keys = redisTemplate.keys((K) shiro_cache_prefix_keys);
        log.debug("获取所有缓存对象的value");
        if (keys.size() == 0) {
            return Collections.emptySet();
        }
        List<V> vs = redisTemplate.opsForValue().multiGet(keys);

        return Collections.unmodifiableCollection(vs);
    }

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
