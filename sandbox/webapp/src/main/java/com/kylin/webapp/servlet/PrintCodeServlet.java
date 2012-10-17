package com.kylin.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kylin.webapp.Constant;
import com.kylin.webapp.WebAppService;
import com.kylin.webapp.servlet.bean.ServletBean;

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
			doHandler(name);
		}
	}

	private void doHandler(String name) {
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
