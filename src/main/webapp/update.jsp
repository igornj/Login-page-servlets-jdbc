
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit your account</title>
    <p>That's literally not much to edit, but I'm studying servlets, SO PLEASE HELP!!</p>
</head>
<body>

<%
    if(session.getAttribute("username") == null){
        response.sendRedirect("login.jsp");
    }
%>

<div>
    <h1>Edit your account -- <%=session.getAttribute("username")%></h1>
    <form action="update" method="POST">
        <input type="hidden" name="userId" value="<%=session.getAttribute("userId")%>"/>
        <label>Username: </label>
        <input type="text" name="username" placeholder="username" required/>
        <label>Password: </label>
        <input type="password" name="password" placeholder="password" required/>
        <button type="submit">Update your astronaut</button>
    </form>
    <a href="delete">If you just want to delete it, you can break my heart clicking in here :(</a>
</div>

<a href="logout">Logout</a>

</body>
</html>
