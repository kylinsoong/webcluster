package com.kylin.webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.kylin.webapp.servlet.CookieServlet;
import com.kylin.webapp.servlet.HelloWorldServlet;
import com.kylin.webapp.servlet.RequestHeaderServlet;
import com.kylin.webapp.servlet.RequestInfoServlet;
import com.kylin.webapp.servlet.RequestParamServlet;
import com.kylin.webapp.servlet.SessionServlet;

public class WebAppService {

   public String createHelloMessage(String name) {
      return "Hello " + name + "!";
   }
   
   public String pageHeader(String title) {
	   return "<html><head><title>" + title +"</title><body>";
   }
   
	public String pageFooter() {
		return "</body></html>";
	}
	
	public String contentType() {
		return "text/html";
	}

	public String getServletClassName(String name) {
		
		if(name.compareTo(Constant.SERVLET_COOKIE) == 0) {
			return CookieServlet.class.getName();
		} else if (name.compareTo(Constant.SERVLET_HELLOWORLD) == 0) {
			return HelloWorldServlet.class.getName();
		} else if (name.compareTo(Constant.SERVLET_REQUESTHEADER) == 0) {
			return RequestHeaderServlet.class.getName();
		} else if (name.compareTo(Constant.SERVLET_REQUESTINFO) == 0) {
			return RequestInfoServlet.class.getName();
		} else if (name.compareTo(Constant.SERVLET_REQUESTPARAM) == 0) {
			return RequestParamServlet.class.getName();
		} else if (name.compareTo(Constant.SERVLET_SESSION) == 0) {
			return SessionServlet.class.getName();
		}
		
		return "ERROR";
	}

	public String getServletContent(String name) throws IOException {
		
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		StringBuffer sb = new StringBuffer();
		String tmp = null;
		
		while((tmp = br.readLine()) != null) {
			sb.append(tmp + "\n");
		}

		return sb.toString();
	}

}
