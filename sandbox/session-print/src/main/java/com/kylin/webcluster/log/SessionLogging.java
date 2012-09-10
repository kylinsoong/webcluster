package com.kylin.webcluster.log;

import org.apache.log4j.Logger;

public class SessionLogging {
	
	private static final Logger logger = Logger.getLogger(SessionLogging.class);
	
	public void logRequest(RequestBean bean) {
		
		logger.info("Session ID: " + bean.getSessionId());
		
		if(logger.isDebugEnabled()) {
			logger.debug("Logging request start");
			logger.debug("Path: " + bean.getBasePath());
			logger.debug("Protocol: " + bean.getProtocol());
			logger.debug("Servlet Path: " + bean.getServletPath());
			logger.debug("Remote Address: " + bean.getRemoteAddr());
			logger.debug("Remote Host: " + bean.getRemoteHost());
			logger.debug("Remote Port" + bean.getRemotePort());
			logger.debug("Remote User: " + bean.getRemoteUser());
			logger.debug("Local Address: " + bean.getLocalAddr());
			logger.debug("Local Name: " + bean.getLocalName());
			logger.debug("Local Host: " + bean.getLocalPort());
			logger.debug("Request URL: " + bean.getRequestUrl());
			logger.debug("Request Session ID: " + bean.getRequestSessionId());
			logger.debug("Session Creation Time: " + bean.getCreationDate());
			logger.debug("Session Last Access Time: " + bean.getLastAccessTime());
			logger.debug("-----------------------------");
		}
		
	}

}
