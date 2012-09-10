package com.kylin.webcluster.log;

public class RequestBean {
	
	private String path; 
	
	private String basePath; 
	
	private String protocol; 
	
	private String servletPath; 
	
	private String remoteAddr; 
	
	private String remoteHost; 
	
	private String remoteUser; 
	
	private String remotePort; 
	
	private String localAddr; 
	
	private String localName; 
	
	private String localPort; 
	
	private String requestUrl; 
	
	private String requestSessionId; 
	
	private String sessionId; 
	
	private String creationDate; 
	
	private String lastAccessTime;

	public RequestBean(String path, String basePath, String protocol,
			String servletPath, String remoteAddr, String remoteHost,
			String remoteUser, String remotePort, String localAddr,
			String localName, String localPort, String requestUrl,
			String requestSessionId, String sessionId, String creationDate,
			String lastAccessTime) {
		super();
		this.path = path;
		this.basePath = basePath;
		this.protocol = protocol;
		this.servletPath = servletPath;
		this.remoteAddr = remoteAddr;
		this.remoteHost = remoteHost;
		this.remoteUser = remoteUser;
		this.remotePort = remotePort;
		this.localAddr = localAddr;
		this.localName = localName;
		this.localPort = localPort;
		this.requestUrl = requestUrl;
		this.requestSessionId = requestSessionId;
		this.sessionId = sessionId;
		this.creationDate = creationDate;
		this.lastAccessTime = lastAccessTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getServletPath() {
		return servletPath;
	}

	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getRemoteUser() {
		return remoteUser;
	}

	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}

	public String getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}

	public String getLocalAddr() {
		return localAddr;
	}

	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getLocalPort() {
		return localPort;
	}

	public void setLocalPort(String localPort) {
		this.localPort = localPort;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestSessionId() {
		return requestSessionId;
	}

	public void setRequestSessionId(String requestSessionId) {
		this.requestSessionId = requestSessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(String lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
	

}
