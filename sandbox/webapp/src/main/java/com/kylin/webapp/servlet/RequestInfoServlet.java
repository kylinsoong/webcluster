package com.kylin.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kylin.webapp.WebAppService;

@WebServlet("/RequestInfo")
public class RequestInfoServlet extends HttpServlet{

	private static final long serialVersionUID = 2676816011506444992L;

	@Inject
	private WebAppService service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType(service.contentType());

		PrintWriter out = resp.getWriter();
		
		out.println(service.pageHeader("Request Information Example"));
		out.println("<h3>Request Information Example</h3>");
		
        out.println("Method: " + request.getMethod() + "<br>");
        out.println("Protocol: " + request.getProtocol() + "<br>");
        out.println("<br>");
        
        out.println("Request URI: " + request.getRequestURI() + "<br>");
        out.println("PathInfo: " + request.getPathInfo() + "<br>");
        out.println("Path: " + request.getContextPath() + "<br>");
        out.println("Base Path: " + request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + "<br>");
        out.println("Servlet Path: " + request.getServletPath() + "<br>");
        out.println("<br>");
       
        out.println("Remote Address: " + request.getRemoteAddr() + "<br>");
        out.println("Remote Host: " + request.getRemoteHost() + "<br>");
        out.println("Remote User: " + request.getRemoteUser() + "<br>");
        out.println("Remote Port: " + request.getRemotePort() + "<br>");
        out.println("<br>");
        
        out.println("Local Address: " + request.getLocalAddr() + "<br>");
        out.println("Local Name: " + request.getLocalName() + "<br>");
        out.println("Local Port: " + request.getLocalPort() + "<br>");
        out.println("<br>");
        
        String requestSessionId = null;
        if(request.getRequestedSessionId() != null) {
        	requestSessionId = request.getRequestedSessionId().toString();
        }
        out.println("Request Session ID: " + requestSessionId + "<br>");
        out.println("<br>");
        
        out.println("Session ID: " + request.getSession().getId() + "<br>");
        out.println("Session Creation Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss(S)").format(new Date(request.getSession().getCreationTime())) + "<br>");
        out.println("Session Last Access Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss(S)").format(new Date(request.getSession().getLastAccessedTime())) + "<br>");
        
		out.println(service.pageFooter());
		
		out.close();
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
