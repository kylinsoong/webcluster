package com.kylin.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kylin.webapp.WebAppService;

@WebServlet("/RequestHeader")
public class RequestHeaderServlet extends HttpServlet{

	private static final long serialVersionUID = 649387125992625387L;

	@Inject
	private WebAppService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType(service.contentType());

		PrintWriter out = resp.getWriter();
		
		out.println(service.pageHeader("Request Header Example"));
		
		out.println("<h3>Request Header Example</h3>");
		
		Enumeration e = req.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            String value = req.getHeader(name);
            out.println(name + ": " + value + "<br>");
        }
		
		out.println(service.pageFooter());
		
		out.print(service.servletReturnStr());
		
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
