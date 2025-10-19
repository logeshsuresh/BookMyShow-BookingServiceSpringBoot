package com.logesh.bookmyshow.services;

import java.util.concurrent.TimeUnit;

public interface CacheService {
    void set(String key, String value);
    void set(String key, String value, Integer ttl, TimeUnit timeUnit);
    Object get(String key);
    void delete(String key);
    void getAllKeysAndValues();
}
