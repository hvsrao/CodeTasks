package com.company.custom.cache;

import com.company.custom.cache.service.impl.DataService;

public class MainCacheTestApplication {

	public static void main(String[] args) {
		DataService service = new DataService();
		service.put("1", 1);
		service.put("2", 2);
		service.put("3", 3);
		service.put("4", 4);
		service.put("5", 5);
		service.put("6", 6);
		
		System.out.println(service.get("6"));
		
		DataService service1 = new DataService();
		service1.put("1", 1);
		service1.put("2", 2);
		service1.put("3", 3);
		service1.put("4", 4);
		service1.put("5", 5);
		service1.put("6", 123);
		
		System.out.println(service.get("6"));
		

	}

}
