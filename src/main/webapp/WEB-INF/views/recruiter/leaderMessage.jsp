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
    <script src="<%=basePath%>static/js/admin/leaderMessage.js"></script>
</head>
<body>
<br>
<div style="background: #f0ad4e">
    <h1 align="center">负责人列表</h1>
</div>
<br>
<br>
<div class="demoTable" align="center" >

    <div class="layui-inline">
        <input class="layui-input" name="id" id="selectSchoolId" autocomplete="off" placeholder="请输入高校名称">
    </div>
    &nbsp
    <button class="layui-btn" data-type="reload" onclick="leaderCheck()" >查询</button>

</div>
</div>
<div align="center">
    <table class="layui-table" lay-data="{width: 1300, height:500, url:'/allLeader', page:true,id:'idTest'} "
           lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{field:'R', width:80, fixed: true, align : 'center'}">序号</th>
            <%--            <th lay-data="{field:'cid', align : 'left'}">负责人编号</th>--%>
            <th lay-data="{field:'cname', align : 'left'}">负责人姓名</th>
            <th lay-data="{field:'uname', align : 'left'}">所属学校</th>
            <th lay-data="{field:'csex', align : 'left'}">性别</th>
            <th lay-data="{field:'tel', align : 'left'}">联系电话</th>
            <th lay-data="{field:'job', align : 'left'}">职位</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
