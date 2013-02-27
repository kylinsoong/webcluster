package com.kylin.webcluster.hasingleton.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsLoader {
	
	private static final String PROP_NAME = "jndiName.properties";
	private static final String SCHEDULER_NAME = "scheduler";
	
	private static Properties props = null;
	
	public static Properties getProps()  {
		if(null == props) {
			InputStream in = null;
			try {
                in = PropsLoader.class.getClassLoader().getResourceAsStream(PROP_NAME);
                props = new Properties();
                props.load(in);
            } catch (IOException e) {
            	throw new PropertiesLoaderException(e);
            } finally {
            	try {
					in.close();
				} catch (IOException e) {
					throw new PropertiesLoaderException( e);
				}
            }
		}
		return props ;
	}
	
	public static String get(String key) {
		return getProps().getProperty(key);
	}
	
	public static String schedulerJNDI() {
		return getProps().getProperty(SCHEDULER_NAME);
	}
	
	static class PropertiesLoaderException extends RuntimeException {

		private static final long serialVersionUID = -342658369879503250L;
		
		public PropertiesLoaderException(Throwable t){
			super("", t);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(PropsLoader.schedulerJNDI());
	}

}
