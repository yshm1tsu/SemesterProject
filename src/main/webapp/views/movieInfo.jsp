<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href = "style.css" rel = "stylesheet" type="text/css">
</head>
<body>
<div class="form-style-7">
<c:forEach items="${sessionScope.params}" var="element">
    <p>${sessionScope.movieInfo.get(element)}</p>
</c:forEach>
    <p>reviews:<c:forEach items="${sessionScope.reviewPool}" var="element">
    ${element.content}</c:forEach></p>
<c:forEach items="${sessionScope.reviewPool}" var="element">
    <p>${element.content} <label>< name="list" value="volvo">Volvo</label>
        <button>delete</button></p>
</c:forEach>
</div>
</body>
</html>
