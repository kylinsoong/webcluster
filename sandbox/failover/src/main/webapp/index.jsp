<%@ page language="java" import="java.util.*, java.text.*,com.kylin.web.failover.*" pageEncoding="ISO-8859-1"%>

<hr>
<%
//Get current size of heap in bytes
long heapSize = Runtime.getRuntime().totalMemory(); 

//Get maximum size of heap in bytes. The heap cannot grow beyond this size.
long heapMaxSize = Runtime.getRuntime().maxMemory();

// Get amount of free memory within the heap in bytes. 
long heapFreeSize = Runtime.getRuntime().freeMemory();

int size = Buffer.size();
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Web Application Fail Over</title>
</head>

<body>

<table border="1", cellpadding="10", cellspacing="10", align="center", width="80%", frame="above">
  <tr>
    <td>Buffer Size: </td>
    <td><%=size %></td>
  </tr>
  <tr>
    <td>Current Heap Size: </td>
    <td><%=heapSize %></td>
  </tr>
  <tr>
    <td>Max Heap Size: </td>
    <td><%=heapMaxSize %></td>
  </tr>
  <tr>
    <td>Free Heap Size: </td>
    <td><%=heapFreeSize %></td>
  </tr>
 
</table>
<hr>
                <h2>
                        <form name="form1" method="post" action="./failoverServlet?name=add">
                                <input type="submit" name="submit" value="Add to Buffer">
                        </form>
    </h2>
    <hr>
    <h2>
               <form name="form1" method="post" action="./failoverServlet?name=remove">
                                <input type="submit" name="submit" value="Remove from Buffer">
                        </form>
    </h2>
    <hr>   
    <h2>
               <form name="form1" method="post" action="./failoverServlet?name=clear">
                                <input type="submit" name="submit" value="Clear Buffer">
                        </form>
    </h2>
    <hr>        
</body>
