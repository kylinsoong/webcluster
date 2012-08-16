package com.kylin.webcluster.log;

import org.apache.log4j.Logger;

public class SessionLogging {
	
	private static final Logger logger = Logger.getLogger(SessionLogging.class);
	
	public void logRequest(RequestBean bean) {
		logger.info("Logging request start");
		logger.info("	path: " + bean.getBasePath());
		logger.info("	protocol: " + bean.getProtocol());
		logger.info("	servletPath: " + bean.getServletPath());
		logger.info("	remoteAddr: " + bean.getRemoteAddr());
		logger.info("	remoteHost: " + bean.getRemoteHost());
		logger.info("	remotePost" + bean.getRemotePort());
		logger.info("	remoteUser: " + bean.getRemoteUser());
		logger.info("	localAddr: " + bean.getLocalAddr());
		logger.info("	localName: " + bean.getLocalName());
		logger.info("	localHost: " + bean.getLocalPort());
		logger.info("	requestURL: " + bean.getRequestUrl());
		logger.info("	requestSessionID: " + bean.getRequestSessionId());
		logger.info("	sessionID: " + bean.getSessionId());
		logger.info("	session creation time: " + bean.getCreationDate());
		logger.info("	session last access time: " + bean.getLastAccessTime());
		logger.info("-----------------------------");
	}

}
