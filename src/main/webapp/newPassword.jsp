<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<h1>Reset your password</h1>
<div>
    <div>
        <p>Enter your new password</p>
        <p>${message}</p>
    </div>

    <div>
        <form action="newPassword" method="POST">
            <label>New password: </label>
            <input type="password" name="password" placeholder="Enter your new password" required/>
            <input type="password" name="confPassword" placeholder="Confirm your new password" required/>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>
</body>

</html>

