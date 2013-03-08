package com.kylin.webapp.servlet.redirect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kylin.webapp.WebAppService;

@WebServlet("/PassParamServlet")
public class PassParamServlet extends HttpServlet {

	private static final long serialVersionUID = 8828690451027102192L;

	
	@Inject
	private WebAppService service;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		resp.setContentType(service.contentType());
		
		PrintWriter out = resp.getWriter();
		
		out.println(service.pageHeader("PassParamServlet"));
		out.println("<h3>PassParamServlet</h3>");
		
		out.println("Print Parameter value" + "<br>");
		out.println("<br>");
		
		String value = createValue();
		out.println(value);
		out.println("<br>");
//		out.close();
		
		String location = "http://localhost:8080/webapp/HTTPHeaderServlet?name=" + value;
		

		RequestDispatcher dispatcher = req.getRequestDispatcher(location);
		dispatcher.forward(req, resp);
		
//		resp.sendRedirect(location);
		
	}

	private String createValue() {
		String result = "-";
		return result;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
