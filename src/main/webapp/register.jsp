<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
</body>
<h1>Register to go to MARS</h1>
<div>
    <div>
        <p>Do you feel sometimes it's time to take a ride in another planet, cause this one it's already done for?.</p>
        <p>Don't worry I got you! just tell me who are you by creating an Account. HAVE A NICE TRIP</p>
    </div>

    <div>
        <form action="register" method="POST">
            <label>Username: </label>
            <input type="text" name="username" placeholder="username" required/>
            <label>Email: </label>
            <input type="email" name="email" placeholder="email" required/>
            <label>Password: </label>
            <input type="password" name="password" placeholder="password" required/>
            <button type="submit">I want to go to MARS!!</button>
        </form>
        <a href="login.jsp">You already have an account?, click here!</a>
    </div>

    <p><i>This is just a Study project you silly, your info doesn't give me anything as well so we're bussin <3</i></p>
</div>
</html>
