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
    <script src="<%=basePath%>static/js/admin/schoolMessage.js"></script>
</head>
<body>
<br>
<div style="background: #f0ad4e">
    <h1 align="center">高校列表</h1>
</div>
<br>
<br>
<div class="demoTable" align="center" >

    <div class="layui-inline">
        <input class="layui-input" name="id" id="selectSchoolId" autocomplete="off" placeholder="请输入高校名称">
    </div>
    &nbsp
    <button class="layui-btn" data-type="reload" onclick="schoolCheck()" >查询</button>

    <button class="layui-btn " data-type="reload" id="idInput" onclick="schoolSubmit()">添加</button>

    <button class="layui-btn layui-btn-danger" data-type="reload" onclick="schoolSomeDel()" >批量删除</button>

</div>
</div>
<div align="center">
    <table class="layui-table" lay-data="{width: 1300, height:500,url:'/allSchool', page:true,id:'idTest'} "
           lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{type:'checkbox', fixed: 'left'}">全选</th>
            <th lay-data="{field:'R', width:80, fixed: true, align : 'center'}">序号</th>
            <th lay-data="{field:'uname', align : 'left'}">高校名称</th>
            <th lay-data="{field:'uaddr', align : 'left'}">高校地址</th>
            <th lay-data="{field:'ename', align : 'left'}">所属招聘人员</th>
            <th lay-data="{fixed: 'right', width:190, align:'center', toolbar: '#barDemo'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

</script>
<%@include file="schoolMessageShow.jsp" %>
</body>
</html>
