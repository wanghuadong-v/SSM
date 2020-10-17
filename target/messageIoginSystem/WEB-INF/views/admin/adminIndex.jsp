<%--
  Created by IntelliJ IDEA.
  User: HelloWorld
  Date: 2020/7/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + path;
%>
<html>
<head>
    <link rel="stylesheet" href="<%=basePath%>static/css/main.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/base.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/layui.css"  media="all">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/modules/layer/default/layer.css" type="text/css">

    <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/js/layui.js" charset="utf-8"></script>

</head>
<body>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item" ><a href="/toStaffMessage" target="showContent"  style="text-decoration-line: none">员工管理</a></li>
                <li class="layui-nav-item" style="text-decoration-line: none"><a href="/toSchoolMessage"  target="showContent"  style="text-decoration-line: none">高校管理</a></li>
                <li class="layui-nav-item" style="text-decoration-line: none"><a href="/toLeaderMessage"  target="showContent"  style="text-decoration-line: none">负责人管理</a></li>
<%--                <li class="layui-nav-item" style="text-decoration-line: none"><a href="" style="text-decoration-line: none">班级管理</a></li>--%>
<%--                <li class="layui-nav-item" style="text-decoration-line: none"><a href="" style="text-decoration-line: none">解决方案</a></li>--%>
            </ul>
        </div>
    </div>

<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
