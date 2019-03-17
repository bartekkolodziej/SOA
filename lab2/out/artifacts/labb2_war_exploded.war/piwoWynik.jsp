<%@ page import='piwneRzeczy.DoradcaPiwny' %><%--
  Created by IntelliJ IDEA.
  User: brzyn
  Date: 17.03.2019
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<html>
<head>
    <title>Wybrane piwo</title>
    <% String beerColor = DoradcaPiwny.getPiwerko(); %>
    <p>Piwerko wybrane przez Ciebie ma kolor:  <% out.println("<span style='background-color:" + beerColor + "; padding: 20px'></span>"); %></p>

</head>
<body>

</body>
</html>
