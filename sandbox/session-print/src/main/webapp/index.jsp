<%@ page language="java" import="java.util.*, java.text.*,com.kylin.webcluster.log.*" pageEncoding="ISO-8859-1"%>

<table border="1", align="right">
  <tr>
    <td>Count: </td>
    <td><%=Counter.getCount() %></td>
  </tr>
</table>
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
String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss(S)").format(new Date(request.getSession().getCreationTime()));
String lastAccessTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss(S)").format(new Date(request.getSession().getLastAccessedTime()));

new SessionLogging().logRequest(new RequestBean(path, basePath, protocol, servletPath, remoteAddr, remoteHost, remoteUser, remotePort, localAddr, localName, localPort, requestUrl, requestSessionId, sessionId, creationDate, lastAccessTime));

%>
Protocol: <%=protocol %><br><br>
Remote Address: <%=remoteAddr %> &nbsp;&nbsp;&nbsp; Remote Host: <%=remoteHost %> &nbsp;&nbsp;&nbsp; Remote User: <%=remoteUser %> &nbsp;&nbsp;&nbsp; Remote Port: <%=remotePort %><br><br>
Local Address: <%=localAddr %> &nbsp;&nbsp;&nbsp; Local Name: <%=localName %> &nbsp;&nbsp;&nbsp; LocalPort: <%=localPort %><br><br>
<table border="1", cellpadding="10", cellspacing="10", align="center", width="80%", frame="above">
  <tr>
    <td>Request URL: </td>
    <td><%=requestUrl %></td>
  </tr>
  <tr>
    <td>Request Session ID: </td>
    <td><%=requestSessionId %></td>
  </tr>
  <tr>
    <td>Session ID: </td>
    <td><%=sessionId %></td>
  </tr>
  <tr>
    <td>Creation Date: </td>
    <td><%=creationDate %></td>
  </tr>
  <tr>
    <td>Last Access Time: </td>
    <td><%=lastAccessTime %></td>
  </tr>
</table>
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
    <hr>
    <h2>
                        <form name="form2" method="post" action="sessionPrint">
                                <input type="submit" name="submit" value="Print Session ID">
                        </form>
    </h2>
</body>
