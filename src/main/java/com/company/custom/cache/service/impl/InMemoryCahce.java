package com.company.custom.cache.service.impl;

import com.company.custom.cache.contract.CacheService;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCahce {
	
	private static int CACHE_SIZE = 5;
	 
    private ConcurrentHashMap<String, Object> cache;
 
    public InMemoryCahce() {
    	cache = new ConcurrentHashMap<String, Object>(CACHE_SIZE);
    }
    
    public InMemoryCahce(int size) {
    	CACHE_SIZE = size;
    	cache = new ConcurrentHashMap<String, Object>(size);
    }

    /**
     * Retrieves the Object for the provided key from the cache
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return cache.get(key);
    }

    /**
     * Stores the Object into cache for associated key
     * @param key
     * @param value
     * @return
     */
    public boolean put(String key, Object value) {
        if (key == null) {
            return false;
        }
        //If excceds size return
        if (cache.size() == CACHE_SIZE) {
            return false;
        }
        if (value == null) {
            cache.remove(key);
        } else {
            cache.put(key, value);
        }
        
        return true;
    }

    /**
     * Removes the key from the cache
     *
     * @param key : key to be removed from cache
     */
    public void remove(String key) {
        cache.remove(key);
    }

    /**
     * Clears the cache
     */
    public void clear() {
        cache.clear();
    }

    /**
     * returns the size of the cache
     *
     * @return
     */
    public long size() {
        return cache.entrySet().stream().count();
    }
 
	
}