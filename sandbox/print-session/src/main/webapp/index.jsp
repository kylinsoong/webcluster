<%@ page language="java" import="java.util.*, java.text.*, com.kylin.webcluster.log.*" pageEncoding="ISO-8859-1"%>
<hr>
<% 
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
String protocol = request.getProtocol();
String servletPath = request.getServletPath();
String remoteAddr = request.getRemoteAddr();
String remoteHost = request.getRemoteHost();
String remoteUser = request.getRemoteUser();
String remotePort = request.getRemotePort() + "";
String localAddr = request.getLocalAddr();
String localName = request.getLocalName();
String localPort = request.getLocalPort() + "";
String requestUrl = request.getRequestURL().toString();
String requestSessionId = null;
if(request.getRequestedSessionId() != null) {
	requestSessionId = request.getRequestedSessionId().toString();
}
String sessionId = request.getSession().getId();
String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss(S) E").format(new Date(request.getSession().getCreationTime()));
String lastAccessTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss(S) E").format(new Date(request.getSession().getLastAccessedTime()));

new SessionLogging().logRequest(new RequestBean(path, basePath, protocol, servletPath, remoteAddr, remoteHost, remoteUser, remotePort, localAddr, localName, localPort, requestUrl, requestSessionId, sessionId, creationDate, lastAccessTime));

%>
Protocol: <%=protocol %><br><br>
Remote Address: <%=remoteAddr %> &nbsp;&nbsp;&nbsp; Remote Host: <%=remoteHost %> &nbsp;&nbsp;&nbsp; Remote User: <%=remoteUser %> &nbsp;&nbsp;&nbsp; Remote Port: <%=remotePort %><br><br>
 local Address: <%=localAddr %> &nbsp;&nbsp;&nbsp; local Name: <%=localName %> &nbsp;&nbsp;&nbsp; localPort: <%=localPort %><br><br>
requestUrl: <%=requestUrl %><br><br>
requestSessionId: <%=requestSessionId %><br><br>
sessionId: <%=sessionId %><br><br>
creationDate: <%=creationDate %><br><br>
lastAccessTime: <%=lastAccessTime %><br><br>
<%
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>View request session</title>
</head>

<body>
<hr>
                <h2>
                        <form name="form1" method="post" action="index.jsp">
                                <input type="submit" name="submit" value="View request session">
                        </form>
    </h2>
</body>
