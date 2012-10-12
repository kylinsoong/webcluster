package com.kylin.webapp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class WebAppUtility {
	
	private static String servletPath = "src/main/java/com/kylin/webapp/servlet/";

	private static String[] servletName = new String[]{"CookieServlet.java", "HelloWorldServlet.java", "RequestHeaderServlet.java", "RequestInfoServlet.java", "RequestParamServlet.java", "SessionServlet.java"};
	
	public static void writeServlet() throws IOException {
		
		for(String name : servletName) {
			
			String content = readFileFromClasspath(servletPath + "CookieServlet.java");
			
			File file = new File(name.substring(0, name.length() -5) + ".html");
			file.createNewFile();
			
			FileWriter writer = new FileWriter(file);
			writer.write(content);
			writer.flush();
			writer.close();
			
			System.out.println("Generate File: " + file.getAbsolutePath());
		}
		
	}

	public static String readFileFromClasspath(String path) throws IOException {

		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
		
		StringBuffer sb = new StringBuffer();
		String tmp = null;
		
		while((tmp = br.readLine()) != null) {
			sb.append(tmp + "\n");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		WebAppUtility.writeServlet();
	}

}
