package com.company.custom.cache.contract;

/**
 * This is the contract for cache
 */
public interface CacheService {

    /**
     * This is the contract method which helps to retrieve the data based on key from the cache
     * @param key : key
     * @return Returns the object for the provided key
     */
	Object get(String key);

    /**
     * This is the contract method to store the key as String and Value as Object in the cache
     *
     * @param key : Key to be stored in the cache
     * @param value : Value as an object associated with the key
     */
    void put(String key, Object value);

}
