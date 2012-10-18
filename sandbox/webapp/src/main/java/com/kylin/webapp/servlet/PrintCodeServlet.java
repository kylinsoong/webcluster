package com.kylin.webapp.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kylin.webapp.WebAppService;
import com.kylin.webapp.servlet.bean.ServletBean;
import com.kylin.webapp.util.WebAppLoader;

@WebServlet("/PrintCode")
public class PrintCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 606460006431707450L;

	@Inject
	private WebAppService service;
	
	@Inject
	private ServletBean bean;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		if(null != name) {
			bean.setContent(WebAppLoader.getInstance().get(name).getContent());
		}
		
		resp.sendRedirect(service.servletlocation());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
