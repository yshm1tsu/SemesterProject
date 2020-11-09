<%--
  Created by IntelliJ IDEA.
  User: musa
  Date: 08.11.2020
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href = "style.css" rel = "stylesheet" type="text/css">
</head>
<body>
<form action= "${pageContext.request.contextPath}/search" method='POST' class = "form-style-7" >
    <ul>
        <li>
            <label>Search</label>
            <input name="s"  type="search">
            <span>Enter title name</span>
        </li>
        <li>
            <input type="submit" value="Send This" >
        </li>
    </ul>
</form>
</body>
</html>
