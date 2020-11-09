<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>auth</title>
    <link href = "style.css" rel = "stylesheet" type="text/css">
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method='POST' name="form" class="form-style-7">
    <ul>
        <li>
            <label>Email</label>
            <input type="email" name="email" maxlength="100">
            <span>Enter a valid email address</span>
        </li>
        <li>
            <label>Password</label>
            <input type="password" name="psw" maxlength="100">
            <span>Enter a valid password</span>
        </li>
        <li>
            <label>Password</label>
            <input type="password" name="psw-repeat" maxlength="100">
            <span>Confirm a password</span>
        </li>
        <li>
            <input type="submit" value="Send This" >
        </li>
    </ul>
</form>
</body>
</html>

