package com.kylin.webapp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadFileToString {

	public static void main(String[] args) throws IOException {
		
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("servlet/HelloWorldServlet");
	
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		StringBuffer sb = new StringBuffer();
		String tmp = null;
		
		while((tmp = br.readLine()) != null) {
			sb.append(tmp + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
