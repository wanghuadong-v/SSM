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
    <script src="<%=basePath%>static/js/administrator/classMessage.js"></script>
</head>
<body>
<br>
<div style="background: #f0ad4e">
    <h1 align="center">班级列表</h1>
</div>
<br>
<br>
<div class="demoTable" align="center" >

    <button class="layui-btn " data-type="reload" id="idInput" onclick="staffSubmit()">添加</button>

    <button class="layui-btn layui-btn-danger" data-type="reload"  onclick="staffSomeDel()">批量删除</button>

</div>
</div>
<div align="center">
    <table class="layui-table" lay-data="{width: 1300, height:500,url:'/allClass', page:true,id:'idTest'} "
           lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{type:'checkbox', fixed: 'left'}">全选</th>
            <th lay-data="{field:'R', width:80, fixed: true, align : 'center'}">序号</th>
            <th lay-data="{field:'cliname', align : 'center'}">班级名称</th>
            <th lay-data="{field:'opentime', align : 'center'}">开班时间</th>
            <th lay-data="{fixed: 'right', width:190, align:'center', toolbar: '#barDemo'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

</script>
<div class="modal fade" id="myModel" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle">信息添加</h4>
            </div>
            <div class="modal-body">
                <ul>
                    <li class="list-group-item clearfix">
                        <form action="">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2" style="display: inline-block">班级名称</label>
                                    <div class="col-sm-5" >
                                        <input type="text" class="layui-input" id="className" onblur="checkClassName()">
                                        <span class="checkMsg" id="checkClassNameMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                        <label class="col-sm-2">开班时间</label>
                                        <div class="col-sm-5" >
                                            <input type="text" name="date" id="date" lay-verify="date" onblur="checkClassTime()" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                                            <span class="checkMsg" id="checkClassTimeMsg"></span>
                                        </div>
                                </div>
                            </div>
                            <br/>
                            <div class="modal-footer">
                                <button class="btn btn-default"  data-dismiss="modal">关闭</button>
                                <%--                                <button class="btn btn-primary" id="submitBtn" onclick="summitQuestion()" >提交</button>--%>
                                <input  type="button" class="btn btn-primary" id="submitBtn" onclick="summitStaffMessage()" value="提交">
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModel1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 740px">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modalTitle1">信息查看</h4>
            </div>
            <div class="modal-body" >
                <ul>
                    <li class="list-group-item clearfix">
                        <form action="">
                            <table class="layui-table" lay-data="{width: 676, height:400,url:'/allStudent', page:true,id:'idTest1'} "
                                   lay-filter="demo">
                                <thead>
                                <tr>
                                    <th lay-data="{field:'R', width:80, fixed: true, align : 'center'}">序号</th>
                                    <%--            <th lay-data="{field:'eid', width:150, fixed: true}">员工编号</th>--%>
                                    <th lay-data="{field:'sname', align : 'center'}">学员姓名</th>
                                    <th lay-data="{field:'tel', align : 'left'}">联系电话</th>
                                    <th lay-data="{field:'uname', align : 'left'}">毕业高校</th>
                                    <th lay-data="{field:'state', align : 'center'}">状态</th>
                                    <th lay-data="{field:'cliname', align : 'center'}">状态</th>
                                </tr>
                                </thead>
                            </table>

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
