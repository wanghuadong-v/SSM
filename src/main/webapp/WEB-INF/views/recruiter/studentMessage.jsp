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
    <script src="<%=basePath%>/static/js/recruiter/studentMessage.js"></script>
</head>
<body>
<br>
<div style="background: #f0ad4e">
    <h1 align="center">学员列表</h1>
</div>
<br>
<br>
<div class="demoTable" align="center" >

    <div class="layui-inline">
        <input class="layui-input" name="id" id="selectStaffName" autocomplete="off" placeholder="请输入学员姓名">
    </div>
    &nbsp
    <button class="layui-btn" data-type="reload" onclick="staffCheck()" >查询</button>

    <button class="layui-btn " data-type="reload" id="idInput" onclick="staffSubmit()">添加</button>

    <button class="layui-btn layui-btn-danger" data-type="reload"  onclick="staffSomeDel()">批量删除</button>

</div>
</div>
<div align="center">
    <table class="layui-table" lay-data="{width: 1300, height:500,url:'/allStudent', page:true,id:'idTest'} "
           lay-filter="demo">
        <thead>
        <tr>
            <th lay-data="{type:'checkbox', fixed: 'left'}">全选</th>
            <th lay-data="{field:'R', width:80, fixed: true, align : 'center'}">序号</th>
            <%--            <th lay-data="{field:'eid', width:150, fixed: true}">员工编号</th>--%>
            <th lay-data="{field:'sname', align : 'left'}">学员姓名</th>
            <th lay-data="{field:'tel', align : 'left'}">联系电话</th>
            <th lay-data="{field:'uname', align : 'left'}">毕业高校</th>
            <th lay-data="{field:'state', align : 'left'}">状态</th>
            <th lay-data="{field:'cliname', align : 'left'}">班级</th>
            <th lay-data="{fixed: 'right', width:190, align:'center', toolbar: '#barDemo'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/html" id="barDemo">
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
                                    <label class="col-sm-2" style="display: inline-block">学员姓名</label>
                                    <div class="col-sm-5" >
                                        <input type="text" class="layui-input" id="staffName" onblur="checkStaffName()">
                                        <span class="checkMsg" id="checkStaffNameMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">联系电话</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="layui-input" id="staffTel" onblur="checkStaffTel()">
                                        <span class="checkMsg" id="checkStaffTelMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">毕业高校</label>
                                    <div class="col-sm-5">
                                        <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="schoolName" >
                                            <option value="" selected>请选择毕业高校</option>
                                        </select>
                                        <span class="checkMsg" id="checkSchoolNameMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">当前状态</label>
                                    <div class="col-sm-5">
                                        <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="studentState" >
                                            <option value="">选择状态</option>
                                            <option >网签</option>
                                            <option >待定</option>
                                        </select>
                                        <span class="checkMsg" id="checkStudentStatebMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">班级</label>
                                    <div class="col-sm-5">
                                        <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="className" >
                                            <option value="" selected>请选择班级</option>
                                        </select>
                                        <span class="checkMsg" id="checkClassNameMsg"></span>
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
</body>
</html>
