package com.company.custom.cache.service.impl;

import com.company.custom.cache.contract.CacheService;

/**
 * This is data service which implements CacheService
 */
public class DataService implements CacheService {

	/**
	 * This method helps to retrieve Object for the provided key
	 * @param key : key
	 * @return : Returns the Object for the provided key
	 */
	public Object get(String key) {
		InMemoryCahce inMemory = new InMemoryCahce();
		if(inMemory.get(key) != null) {
			return inMemory.get(key);
		}else {
			FileSystemCache fileCache = new FileSystemCache();
			return fileCache.load(key);
		}
	}

	/**
	 * Stores the Object with the associated key
	 *
	 * @param key : Key to be stored in the cache
	 * @param value : Value as an object associated with the key
	 */
	public void put(String key, Object value) {
		InMemoryCahce inMemory = new InMemoryCahce();
		FileSystemCache fileCache = new FileSystemCache();
		inMemory.put(key, value);
		fileCache.store(key, value);
	}

}
