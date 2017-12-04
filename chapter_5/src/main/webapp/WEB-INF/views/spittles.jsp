<%--
  Created by IntelliJ IDEA.
  User: kang
  Date: 17-12-2
  Time: 下午3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittles</title>
</head>
<body>
<c:forEach items="${spittleList}" var="spittle">
    <li id="spittle_<c:out value="${spittle.id}"/>">
        <div><c:out value="${spittle.message}"/> </div>
        <div><span><c:out value="${spittle.time}"/></span> </div>
        <div><span><c:out value="${spittle.latitude}"/>, <c:out value="${spittle.longitude}"/> </span></div>
    </li>
</c:forEach>
</body>
</html>
