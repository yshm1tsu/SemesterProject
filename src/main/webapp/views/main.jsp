<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movies</title>
    <link href = "style.css" rel = "stylesheet" type="text/css">
</head>
<body>
<input type="checkbox" id="hmt" class="hidden-menu-ticker">
<label class="btn-menu" for="hmt">
    <span class="first"></span>
    <span class="second"></span>
    <span class="third"></span>
</label>
<div class = "header">
    <span class = "contentMenu">


    </span>
</div>
<ul class="hidden-menu">
    <li class = 'kekw'><a class = "menuText" href="">Movies</a></li>
    <li class = 'kekw'><a class = "menuText" href="${pageContext.request.contextPath}/watchlist">Watch later</a></li>
    <li class = 'kekw'><a class = "menuText" href="${pageContext.request.contextPath}/review">Reviews</a></li>
</ul>

</div>
</body>
</html>