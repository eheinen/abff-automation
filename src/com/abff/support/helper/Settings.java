package com.abff.support.helper;

import java.io.InputStream;

public class Settings {
	
	private static final String RESOURCE_NAME = "settings.properties";
	
	public Settings(){
		loadProperties(null);
	}
	
	public Settings(String resourcePathName){
		loadProperties(resourcePathName);
	}
	
	/**
	 * Responsible to load a resource by path and name.
	 * @param resourcePathName Resource path and file. If is null or empty, so the system will get settings.properties as default.
	 */
	private void loadProperties(String resourcePathName){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			resourcePathName = (Utils.isNullOrEmpty(resourcePathName) ? RESOURCE_NAME : resourcePathName);
			InputStream resourceStream = loader.getResourceAsStream(resourcePathName);
		    System.getProperties().load(resourceStream);
		}catch (Exception e) {
			new RuntimeException("Could not open the settings file.");
		}
	}
}
