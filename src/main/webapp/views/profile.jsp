<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/views/_header.jsp" %>

<h2>Hello, ${user.get("email")}</h2>
<p>My reviews</p>
<%@include file="/views/_footer.jsp" %>