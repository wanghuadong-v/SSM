<%--
  Created by IntelliJ IDEA.
  User: HelloWorld
  Date: 2020/7/19
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + path;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎${sessionScope.job}:${sessionScope.name}

</body>
</html>
