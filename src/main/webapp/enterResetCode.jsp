<%--
  Created by IntelliJ IDEA.
  User: igorn
  Date: 7/2/2022
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset your password</title>
</head>
<body>
<h1>Enter the reset code send in your email</h1>
<form action="validateResetCode">
    <input type="text" name="resetCode" placeholder="Enter the reset code"/>
    <button type="submit">Reset password</button>
</form>

</body>
</html>
