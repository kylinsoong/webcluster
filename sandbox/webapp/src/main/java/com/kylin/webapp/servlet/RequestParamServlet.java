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

@WebServlet("/RequestParam")
public class RequestParamServlet extends HttpServlet {

	private static final long serialVersionUID = 7345596678719362119L;

	@Inject
	private WebAppService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType(service.contentType());
		
		PrintWriter out = resp.getWriter();
		
		out.println(service.pageHeader("Request Parameters Example"));
		
		out.println("<h3>Request Parameters Example</h3>");
        out.println("Parameters in this request:<br>");
        
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        
        if (firstName != null || lastName != null) {
            out.println("First Name: " + firstName + "<br>");
            out.println("Last Name: " + lastName + "<br>");
        } else {
            out.println("No Parameters, Please enter some");
        }
        out.println("<P>");
        out.print("<form action=\"");
        out.print("RequestParam\" ");
        out.println("method=POST>");
        out.println("First Name:");
        out.println("<input type=text size=20 name=firstname>");
        out.println("<br>");
        out.println("Last Name:");
        out.println("<input type=text size=20 name=lastname>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");
		
		out.println(service.pageFooter());
		
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
