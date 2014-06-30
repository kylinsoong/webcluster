package org.jboss.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

public class ClassLoaderViewServlet extends HttpServlet {

	private static final long serialVersionUID = 6766348308173972664L;
	
	public ClassLoaderViewServlet() {
		System.out.println(" ClassLoaderViewServlet Construct");
		System.out.println(DocumentBuilderFactory.newInstance());
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(" ClassLoaderViewServlet doPost");
		System.out.println(DocumentBuilderFactory.newInstance());
	}
	



}
