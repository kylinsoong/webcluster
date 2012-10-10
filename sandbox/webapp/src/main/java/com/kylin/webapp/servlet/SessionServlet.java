package com.kylin.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kylin.webapp.WebAppService;

@WebServlet("/Session")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = -8407250690241513430L;

	@Inject
	private WebAppService service;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType(service.contentType());
		
		PrintWriter out = resp.getWriter();
		
		out.println(service.pageHeader("Session Test Example"));
		out.println("<h3>Session Test Example</h3>");
		
		HttpSession session = req.getSession(true);
        out.println("Session ID: " + session.getId());
        out.println("<br>");
        out.println("Created: ");
        out.println(new Date(session.getCreationTime()) + "<br>");
        out.println("Last Accessed: ");
        out.println(new Date(session.getLastAccessedTime()));

        String dataName = req.getParameter("dataname");
        String dataValue = req.getParameter("datavalue");
        if (dataName != null && dataValue != null) {
            session.setAttribute(dataName, dataValue);
        }

        out.println("<P>");
        out.println("The following data is in your session: " + "<br><br>");
        Enumeration names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String value = session.getAttribute(name).toString();
            out.println(name + " = " + value + "<br>");
        }

        out.println("<P>");

        out.print("<form action=\"");
        out.print(resp.encodeURL("Session"));
        out.print("\" ");
        out.println("method=POST>");
        out.println("Name of Session Attribute: ");
        out.println("<input type=text size=20 name=dataname>");
        out.println("<br>");
        out.println("Value of Session Attribute: ");
        out.println("<input type=text size=20 name=datavalue>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");

        out.println("<P>GET based form:<br>");
        out.print("<form action=\"");
        out.print(resp.encodeURL("Session"));
        out.print("\" ");
        out.println("method=GET>");
        out.println("Name of Session Attribute: ");
        out.println("<input type=text size=20 name=dataname>");
        out.println("<br>");
        out.println("Value of Session Attribute: ");
        out.println("<input type=text size=20 name=datavalue>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");

        out.print("<p><a href=\"");
        out.print(resp.encodeURL("Session?dataname=foo&datavalue=bar"));
        out.println("\" >URL encoded </a>");

		
		out.println(service.pageFooter());
		
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
