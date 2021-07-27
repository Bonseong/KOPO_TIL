package kr.ac.kopo.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	public Properties prop;

	public HandlerMapping() {
		this("D:\\KOPO\\CODE\\JAVA\\web-workspace\\Total-Account-Web\\bean.properties");
	}
	
	public HandlerMapping(String propLoc) {
		mappings = new HashMap<>();
		prop = new Properties();
		try (InputStream is = new FileInputStream(propLoc)) {
		
			prop.load(is);
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());
					
				Class<?> clz = Class.forName(className);
				mappings.put(key.toString(), (Controller)clz.getDeclaredConstructors()[0].newInstance());
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}

}





















