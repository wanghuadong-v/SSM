<%--
  Created by IntelliJ IDEA.
  User: HelloWorld
  Date: 2020/5/29
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
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
                                    <label class="col-sm-2" style="display: inline-block">员工姓名</label>
                                    <div class="col-sm-5" >
                                        <input type="text" id="idInput" style="display: none">
                                        <%--                                            <input type="text" id="idInput">--%>
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
                                    <label class="col-sm-2">职位</label>
                                    <div class="col-sm-5">
                                        <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="staffJob"  onblur="checkStaffJob()">
                                            <option value="">直接选择员工的职位</option>
                                            <option >校长</option>
                                            <option >管理员</option>
                                            <option >招聘人员</option>
                                            <option >行政人员</option>
                                        </select>
                                        <span class="checkMsg" id="checkStaffJobMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">密码</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="layui-input" id="staffPwd" onblur="checkStaffPwd()">
                                        <span class="checkMsg" id="checkStaffPwdMsg"></span>
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
