
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Review</title>
    <link href = "style.css" rel = "stylesheet" type="text/css">
</head>
<body>
<form action= "${pageContext.request.contextPath}/review" method='POST' accept-charset="utf-8">
    <ul>
        <li>
            <label>Title</label>
            <input type="text" name="title" maxlength="100">
            <span>Enter title name</span>
        </li>
        <li>
            <label>Comment</label>
            <input type="text" name="comment" maxlength="1000">
            <span>What do you think?</span>
        </li>
        <li>
            <input type="submit" value="Send This" >
        </li>
    </ul>
</form>
<c:forEach items="${requestScope.reviewRep}" var="element">
    <h2>${element.title} </h2>
    <p>${element.content}</p>
</c:forEach>
</body>
</html>
