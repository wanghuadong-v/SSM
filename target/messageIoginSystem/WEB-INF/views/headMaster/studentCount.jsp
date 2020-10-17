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
    <script src="<%=basePath%>static/js/headMaster/staffMessage.js"></script>

</head>
<body>
<br>
<div style="background: #f0ad4e">
    <h1 align="center">学院统计</h1>
</div>
<br>
<br>

<div align="center">
    <table class="layui-table" lay-data="{width: 1300, height:500,url:'/studentCount', id:'idTest'} "
           lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{field:'uname', align : 'center'}">高校名称</th>
            <th lay-data="{field:'co', align : 'center'}">招聘人数</th>
        </tr>
        </thead>
    </table>
</div>

</body>
</html>

</body>
</html>
