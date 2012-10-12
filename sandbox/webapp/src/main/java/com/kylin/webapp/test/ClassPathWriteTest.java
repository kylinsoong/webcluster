package com.kylin.webapp.test;

import java.io.File;
import java.io.IOException;
import java.security.CodeSource;

public class ClassPathWriteTest {

	public static void main(String[] args) throws IOException {

		CodeSource codeSource = ClassPathWriteTest.class.getProtectionDomain().getCodeSource();
	
		String path = codeSource.getLocation().getPath();
		
		boolean isCreated = new File(path + "servlet" ).mkdir();
		
		System.out.println(isCreated);
		
		
	}

}
