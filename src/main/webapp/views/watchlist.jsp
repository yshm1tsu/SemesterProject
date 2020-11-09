
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>watchlist</title>
    <link href = "style.css" rel = "stylesheet" type="text/css">
</head>
<body>
<form action= "${pageContext.request.contextPath}/watchlist" method='POST' class="form-style-7">
    <p>Название фильма<Br>
    <p><input name = "title" maxlength="50" size="50" required></p>
    <label for="rating">Рейтинг:</label>
    <select required id  = "rating", name = "rating">
        <option selected="selected"></option>
        <option>worst movie ever</option>
        <option>bad</option>
        <option>pretty ok</option>
        <option>nice one</option>
        <option>absolute masterpiece</option>
    </select>
    <label for="status">Status:</label>
    <select required id = "status" name = "status">
        <option selected="selected"></option>
        <option>in progress</option>
        <option>finished</option>
        <option>haven't started yet</option>
    </select>
    <label for="add_date">Дата добавления:</label>
    <input type="date" required id = "add_date" name="add_date">
    <p><input type="submit" value="Добавить">
</form>

<c:forEach items="${requestScope['rep']}" var="item">
    ${item.getTitle()}
    ${item.getRating()}<br>
    ${item.getAdd_date()}<br>
    ${item.getRating()}<br>
    ${item.getStatus()}<br>
</c:forEach>
</body>
</html>
