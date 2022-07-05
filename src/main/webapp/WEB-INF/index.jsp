<%--
  Created by IntelliJ IDEA.
  User: igorn
  Date: 6/27/2022
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to MARS</title>
</head>
<body>

<%
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>

<div>
    <p>${message}</p>
    <a href="update.jsp" target="_blank"><p>${username}</p></a>
</div>

<h1>Congrats <%=session.getAttribute("username")%>! Now you are in mars!! far away from your problemas from earth.</h1>
<h2>I hope you enjoy your stay listening to this song that of course uses "mars" alot and, it's also a good honestly.</h2>
<br/>


</body>
</html>
