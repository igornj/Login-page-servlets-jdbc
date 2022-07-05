<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>

<h1>Reset your password</h1>
<div>
  <div>
    <p>Enter your email of the account bellow</p>
    <p>you are going to receive a code on your email to reset your passoword.</p>
  </div>

  <div>
    <form action="forgotPassword" method="POST">
      <label>Email: </label>
      <input type="email" name="email" placeholder="Enter your email" required/>
      <button type="submit">Submit</button>
    </form>
  </div>
</div>
</body>

</html>

