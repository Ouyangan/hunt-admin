package com.hunt.system.security.shiro;

import org.apache.shiro.ShiroException;
import org.apache.shiro.cache.*;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;
import org.apache.shiro.util.SoftHashMap;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author ouyangan
 * @Date 2016/10/9/14:13
 * @Description
 */
public class RedisCacheManger extends AbstractCacheManager {

    private static Logger log = LoggerFactory.getLogger(RedisCacheManger.class);


    @Override
    protected Cache createCache(String name) throws CacheException {
        return new RedisCache<>(name, new SoftHashMap<Object, Object>());
    }
}
