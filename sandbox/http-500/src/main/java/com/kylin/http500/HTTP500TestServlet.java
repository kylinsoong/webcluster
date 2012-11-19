package com.kylin.http500;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HTTP500TestServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(HTTP500TestServlet.class);

	private static final long serialVersionUID = 4534177930203244032L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("HTTP 500 Status Test Servlet");
		
		req.getSession();
		
	}

	
}
