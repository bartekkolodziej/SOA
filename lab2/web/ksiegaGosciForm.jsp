<%--
  Created by IntelliJ IDEA.
  User: brzyn
  Date: 17.03.2019
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ksiega Gosci Form</title>
</head>
<body>

<h2>Księga Gości Logowanie</h2>
<span>(login: bartekko, haslo: password)</span>

<br>
<br>
<br>

<form action="WalidacjaDanych" method="get">
    Login: <input type="text" required name="login"/>
    Hasło: <input type="password" required name="password"/>
    <input type="submit" value="Zaloguj"/>
</form>

<%
if(request.getParameter("invalid") != null && request.getParameter("invalid").equals("true") ){
    out.println("<h3>Błędne dane logowania</h3>");
}
%>

</body>
</html>
