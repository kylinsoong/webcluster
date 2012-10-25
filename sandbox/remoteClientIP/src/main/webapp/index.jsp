<%@ page language="java" import="java.util.*, java.text.*" pageEncoding="ISO-8859-1"%>

<% 
String remoteAddr = request.getRemoteAddr();
String remoteHost = request.getRemoteHost();
String remoteUser = request.getRemoteUser();
String remotePort = request.getRemotePort() + "";
String localAddr = request.getLocalAddr();
String localName = request.getLocalName();
String localPort = request.getLocalPort() + "";
String remoteIP = request.getHeader("X-Forwarded-For");

System.out.println("Remote Client IP: " + remoteIP);

%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>View Remote IP</title>
</head>

<body>
<hr>
Remote Client IP: <%=remoteIP %>
          
</body>
