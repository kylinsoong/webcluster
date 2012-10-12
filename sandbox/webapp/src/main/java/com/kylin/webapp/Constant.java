package com.kylin.webapp;

import com.kylin.webapp.servlet.CookieServlet;
import com.kylin.webapp.servlet.HelloWorldServlet;
import com.kylin.webapp.servlet.RequestHeaderServlet;
import com.kylin.webapp.servlet.RequestInfoServlet;
import com.kylin.webapp.servlet.RequestParamServlet;
import com.kylin.webapp.servlet.SessionServlet;

public class Constant {

	public static final String SERVLET_HELLOWORLD = HelloWorldServlet.class.getSimpleName();
	public static final String SERVLET_COOKIE = CookieServlet.class.getSimpleName();
	public static final String SERVLET_REQUESTHEADER = RequestHeaderServlet.class.getSimpleName();
	public static final String SERVLET_REQUESTINFO = RequestInfoServlet.class.getSimpleName();
	public static final String SERVLET_REQUESTPARAM = RequestParamServlet.class.getSimpleName();
	public static final String SERVLET_SESSION = SessionServlet.class.getSimpleName();

}
