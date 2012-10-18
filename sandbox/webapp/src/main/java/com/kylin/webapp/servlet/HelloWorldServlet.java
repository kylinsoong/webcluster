package com.kylin.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kylin.webapp.WebAppService;

@WebServlet("/HelloWorld")
public class HelloWorldServlet extends HttpServlet {

  
	private static final long serialVersionUID = 1770304184548479022L;

	@Inject
	private WebAppService service;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType(service.contentType());
		
		PrintWriter out = resp.getWriter();
		
		out.println(service.pageHeader("HelloWorld"));
		out.println("<h1>" + service.createHelloMessage("World") + "</h1>");
		out.println(service.pageFooter());
		
		out.print(service.servletReturnStr());
		
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
