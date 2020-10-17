<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + path;
%>
<%--<html>--%>
<%--<head>--%>
<%--    <link rel="stylesheet" href="<%=basePath%>static/css/main.css" type="text/css">--%>
<%--    <link rel="stylesheet" href="<%=basePath%>static/js/css/base.css" type="text/css">--%>
<%--    <link rel="stylesheet" href="<%=basePath%>static/js/css/bootstrap.min.css" type="text/css">--%>
<%--    <link rel="stylesheet" href="<%=basePath%>static/js/css/layui.css" media="all">--%>
<%--    <link rel="stylesheet" href="<%=basePath%>static/js/css/modules/layer/default/layer.css" type="text/css">--%>
<%--    <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.3.1.js"></script>--%>
<%--    <script type="text/javascript" src="<%=basePath%>static/js/bootstrap.min.js"></script>--%>
<%--    <script src="<%=basePath%>static/js/layui.js" charset="utf-8"></script>--%>
<%--    <script src="<%=basePath%>static/js/login/login.js" charset="utf-8"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="" >--%>
<%--    <div class="row">--%>
<%--        <div class="form-group">--%>
<%--            <label class="col-sm-2" style="display: inline-block">用户名：</label>--%>
<%--            <div class="col-sm-5" >--%>
<%--                <input type="text" class="layui-input" name="ename" id="staffName" onblur="checkStaffName">--%>
<%--                <span class="checkMsg" id="checkStaffNameMsg"></span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <br/>--%>
<%--    <div class="row">--%>
<%--        <div class="form-group">--%>
<%--            <label class="col-sm-2">密码：</label>--%>
<%--            <div class="col-sm-5">--%>
<%--                <input type="password" class="layui-input" name="password" id="staffPwd" >--%>
<%--                <span class="checkMsg" id="checkStaffPwdMsg"></span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <br/>--%>
<%--    <div class="row">--%>
<%--        <div class="form-group">--%>
<%--            <label class="col-sm-2">选择登录人员</label>--%>
<%--            <div class="col-sm-5">--%>
<%--                <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="staffJob" >--%>
<%--                    <option value="" selected>选择登录人员</option>--%>
<%--                    <option >校长</option>--%>
<%--                    <option >管理员</option>--%>
<%--                    <option >招聘人员</option>--%>
<%--                    <option >行政人员</option>--%>
<%--                </select>--%>
<%--                <span class="checkMsg" id="checkStaffJobMsg"></span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <br/>--%>
<%--        <input  type="button" class="btn btn-primary" id="submitBtn" onclick="summitSchoolMessage()" value="提交">--%>
<%--    </div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<html lang="en">
    <link rel="stylesheet" href="<%=basePath%>static/css/main.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/base.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/layui.css" media="all">
    <link rel="stylesheet" href="<%=basePath%>static/js/css/modules/layer/default/layer.css" type="text/css">
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/js/layui.js" charset="utf-8"></script>
    <script src="<%=basePath%>static/js/login/login.js" charset="utf-8"></script>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="layui/css/layui.css">
    <style type="text/css">
        .container{
            width: 420px;
            height: 320px;
            min-height: 320px;
            max-height: 320px;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            margin: auto;
            padding: 20px;
            z-index: 130;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 3px 18px rgba(100, 0, 0, .5);
            font-size: 16px;
        }
        .close{
            background-color: white;
            border: none;
            font-size: 18px;
            margin-left: 410px;
            margin-top: -10px;
        }

        .layui-input{
            border-radius: 5px;
            width: 290px;
            height: 40px;
            font-size: 15px;
        }
        .layui-form-item{
            margin-left: -20px;
        }
        #logoid{
            margin-top: -16px;
            padding-left:150px;
            padding-bottom: 15px;
        }
        .layui-btn{
            margin-left: 0px;
            border-radius: 5px;
            width: 200px;
            height: 40px;
            font-size: 15px;
        }
        .verity{
            width: 120px;
        }
        .font-set{
            font-size: 13px;
            text-decoration: none;
            margin-left: 120px;
        }
        a:hover{
            text-decoration: underline;
        }

    </style>
</head>
<body>
<form class="layui-form" action="" method="post">
    <div class="container">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="ename" id="staffName" onblur="checkStaffName" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                <span class="checkMsg" id="checkStaffNameMsg"></span>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密 &nbsp;&nbsp;码</label>
            <div class="layui-input-block">
                <input type="password"  required lay-verify="required" name="password" id="staffPwd" autocomplete="off" placeholder="请输入密码" class="layui-input">
                <span class="checkMsg" id="checkStaffPwdMsg"></span>
            </div>
        </div>
        <div class="layui-form-item">
                    <label class="layui-form-label">选择登录人员</label>
                    <div class="layui-input-block">
                        <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="staffJob" >
                            <option value="" selected>选择登录人员</option>
                            <option >校长</option>
                            <option >管理员</option>
                            <option >招聘人员</option>
                            <option >行政人员</option>
                        </select>
                        <span class="checkMsg" id="checkStaffJobMsg"></span>
                    </div>
        </div>
    <br/>
            <div class="layui-input-block">
<%--                <button class="layui-btn" lay-submit lay-filter="formDemo" id="submitBtn" onclick="summitSchoolMessage()">登陆</button>--%>
                <input  type="button" class="layui-btn" id="submitBtn" onclick="summitSchoolMessage()" value="提交">
            </div>
        </div>
    </div>
</form>
<script type="text/javascript" src="layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        /* laydate.render({
           elem: '#date'
         });
         laydate.render({
           elem: '#date1'
         });

         //创建一个编辑器
         var editIndex = layedit.build('LAY_demo_editor');

         //自定义验证规则
         form.verify({
           title: function(value){
             if(value.length < 5){
               return '标题至少得5个字符啊';
             }
           }
           ,pass: [
             /^[\S]{6,12}$/
             ,'密码必须6到12位，且不能出现空格'
           ]
           ,content: function(value){
             layedit.sync(editIndex);
           }
         });

         //监听指定开关
         form.on('switch(switchTest)', function(data){
           layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
             offset: '6px'
           });
           layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
         });*/

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

    });
</script>
</body>
</html>
