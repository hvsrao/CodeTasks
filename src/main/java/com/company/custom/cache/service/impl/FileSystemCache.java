package com.company.custom.cache.service.impl;

import com.company.custom.cache.constants.FILENAMEConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the implentation class which helps to store the cache into the FileSystem
 */
public class FileSystemCache  {

	/**
	 * This method helps to store the object into file system based on the key
	 * @param key : key to be used to store it associated value object
	 * @param object : Object to be stored with it's key
	 */
	private static void writeToFile(String key, Object object) {
		File file = new File(FILENAMEConstants.FILE_NAME);
		if (!file.exists()) {
			try {
				File directory = new File(file.getParent());
				if (!directory.exists()) {
					directory.mkdirs();
				}
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Make sure your Path is correct in the FILE_NAME");
			}
		}

		try {
			Map<String, Object> map = readFromFile();
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			map.put(key, object);
			out.writeObject(map);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			System.out.println("Got an error while saving data to file " + e.toString());
		}
	}

	/**
	 * This is the utility method which reads the data from the FIle System
	 *
	 * @return : Returns the stored cached data from the file system
	 */
	public static HashMap<String, Object> readFromFile() {
		Map<String, Object> map = new HashMap<String, Object>();
		File file = new File(FILENAMEConstants.FILE_NAME);
		if (!file.exists())
			System.out.println("File doesn't exist");
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			if (file.length() != 0) {
				map = (HashMap) in.readObject();
			}

		} catch (Exception e) {
			System.out.println("error load cache from file " + e.toString());
		}
		return (HashMap<String, Object>) map;
	}

	/**
	 * This method helps to retrieve the object based on the key
	 * @param key : key for which object to be retrieved
	 * @return : Returns the Object associated with the key
	 */
	public Object getObject(String key) {
		HashMap<String, Object> map = readFromFile();
		try {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getKey().equals(key))
					return entry.getValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method helps to load the object from the File System for the provided key
	 * @param key : Key for retrieving associated object
	 * @return : Returns the object for the passed key
	 */
	public Object load(String key) {
		return getObject(key);
	}

	/**
	 * This method helps to store the key and it's associated object to the file system
	 * @param key
	 * @param value
	 */
	public void store(String key, Object value) {
		writeToFile(key, value);
	}
}
