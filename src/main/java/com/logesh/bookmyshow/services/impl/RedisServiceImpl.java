package com.logesh.bookmyshow.services.impl;

import com.logesh.bookmyshow.services.CacheService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements CacheService {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisServiceImpl(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void set(String key, String value) {
        this.stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, String value, Integer ttl,TimeUnit timeUnit) {
        this.stringRedisTemplate.opsForValue().set(key, value, ttl, timeUnit);
    }

    @Override
    public Object get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        this.stringRedisTemplate.delete(key);
    }

    /*
    *   For debugging
    * */
    @Override
    public void getAllKeysAndValues() {
        this.stringRedisTemplate.keys("*").forEach(key -> {
            System.out.println(String.format("Key: %s - Value: %s", key, this.stringRedisTemplate.opsForValue().get(key)));
        });
    }

}
