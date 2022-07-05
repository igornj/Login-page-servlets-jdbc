<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<%
    if(session.getAttribute("username") != null){
        response.sendRedirect("index.jsp");
    }
%>

<h1>Login in into MARS</h1>
<div>
    <div>
        <p>Don't you have that feeling sometimes that it's time to take a ride in another planet, cause this one it's already done for?.</p>
        <p>Don't worry I got you cover! just confirm your identification and HAVE A NICE TRIP</p>
        <h3>${message}</h3>
    </div>

    <div>
        <form action="login" method="POST">
            <label>Username: </label>
            <input type="text" name="username" placeholder="username" required/>
            <label>Password: </label>
            <input type="password" name="password" placeholder="password" required/>
            <button type="submit">Let's go to MARS!!</button>
        </form>
        <a href="forgotPassword.jsp">Forgot password?</a>
        <a href="register.jsp">If you don't have an account, click here!</a>
    </div>

    <p><i>This is just a Study project you silly, your info doesn't give me anything so we're bussin <3</i></p>
</div>
</body>

</html>
