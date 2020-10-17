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
    <script src="<%=basePath%>static/js/headMaster/classMessage.js"></script>

</head>
<body>
<br>
<div style="background: #f0ad4e">
    <h1 align="center">班级列表</h1>
</div>
<br>
<br>

<div align="center">
    <table class="layui-table" lay-data="{width: 1300, height:500,url:'/allClass', page:true,id:'idTest'} "
           lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{field:'R', width:80, fixed: true, align : 'center'}">序号</th>
            <%--                        <th lay-data="{field:'eid', width:150, fixed: true}">员工编号</th>--%>
            <th lay-data="{field:'cliname', align : 'center'}">班级名称</th>
            <th lay-data="{field:'opentime', align : 'center'}">开班时间</th>
            <th lay-data="{fixed: 'right', width:190, align:'center', toolbar: '#barDemo'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>

</script>
<div class="modal fade" id="myModel" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle">信息查看</h4>
            </div>
            <div class="modal-body">
                <ul>
                    <li class="list-group-item clearfix">
                        <form action="">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2" style="display: inline-block" >班级编号</label>
                                    <div class="col-sm-5" >
                                        <input type="text" class="layui-input" id="classId" disabled>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">班级姓名</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="layui-input" id="className" disabled>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">开班时间</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="layui-input" id="classTime" disabled>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="modal-footer">
                                <button class="btn btn-default"  data-dismiss="modal">关闭</button>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>

</body>
</html>
