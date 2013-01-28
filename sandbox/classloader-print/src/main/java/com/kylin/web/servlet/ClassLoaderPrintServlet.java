package com.kylin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClassLoaderPrintServlet extends HttpServlet {

	private static final long serialVersionUID = 6766348308173972664L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println("Print Class Loader Hierarchy:");
		print(loader);
	}
	
	private void print(ClassLoader loader) {
		println("  " + loader);
		if(loader.getParent() != null) {
			print(loader.getParent());
		}
	}
	
	private void println(Object obj) {
		System.out.println(obj);
	}


}
