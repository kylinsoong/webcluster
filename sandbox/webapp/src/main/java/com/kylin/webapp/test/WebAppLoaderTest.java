package com.kylin.webapp.test;

import com.kylin.webapp.util.WebAppLoader;

public class WebAppLoaderTest {

	public static void main(String[] args) {
		
		WebAppLoader instance = WebAppLoader.getInstance();
		
		for(String key : instance.ketSet()) {
			System.out.println(instance.get(key));
			System.out.println("\n----------------\n");
		}
	}

}
