<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: brzyn
  Date: 16.03.2019
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Lab2 SOA - pierwsza aplikacja
  <%
    Date tmp = new Date();

    out.print("<h2>" + tmp.toString() + "</h2>");
  %>
  </body>
</html>
