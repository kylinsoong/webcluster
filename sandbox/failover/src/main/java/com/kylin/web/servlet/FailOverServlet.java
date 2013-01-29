package com.kylin.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kylin.web.failover.Buffer;
import com.kylin.web.failover.CustomHashMap;

public class FailOverServlet extends HttpServlet {

	private static final long serialVersionUID = 6766348308173972664L;
	
	private static final Logger logger = Logger.getLogger(FailOverServlet.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		logger.info("doPost: " + name);
		
		if(name.compareTo("add") == 0) {
			Map map = new CustomHashMap();
			for (int i = 0; i < 50; i++) {
				map.put("name" + i, new byte[1000000]);
			}
			Buffer.add(map);
		} else if(name.compareTo("remove") == 0) {
			Buffer.remove();
		} else if(name.compareTo("clear") == 0) {
			Buffer.clear();
		}
		
		logger.info("Buffer Size: " + Buffer.size());
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
	}
	
	

}
