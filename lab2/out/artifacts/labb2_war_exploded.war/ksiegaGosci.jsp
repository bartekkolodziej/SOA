<%@ page import="java.util.Vector" %>
<%@ page import="KsiegaGosci.Wpis" %><%--
  Created by IntelliJ IDEA.
  User: brzyn
  Date: 17.03.2019
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ksiega Gosci</title>
</head>
<body>

<h2>Send feedback</h2>

<form action="DodajWpis" method="get">
    Imie: <input type="text" required name="name"/>
    Mail: <input type="email" required name="mail"/>
    Komentarz: <input type="text" required name="comment"/>

    <input type="submit" value="Wyslij"/>
</form>

<div style="margin-top: 16px; border: 1px solid grey">
    <%
        Vector<Wpis> feedback = (Vector<Wpis>) session.getAttribute("feedback");
        if(feedback != null){
            for (Wpis e : feedback) {
                out.println("<span>" + e.name + " ("+ e.mail+") pisze: <br> "+e.comment+"</span><br>");
            }
        }

    %>
</div>


</body>
</html>
