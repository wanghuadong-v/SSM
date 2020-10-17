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
                                    <label class="col-sm-2" style="display: inline-block">高校名称</label>
                                    <div class="col-sm-5" >
                                        <input type="text" id="idInput" style="display: none">
                                        <%--                                            <input type="text" id="idInput">--%>
                                        <input type="text" class="layui-input" id="schoolName" onblur="checkSchoolName()">
                                        <span class="checkMsg" id="checkSchoolNameMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">高校地址</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="layui-input" id="schoolAddr" onblur="checkSchoolAddr()">
                                        <span class="checkMsg" id="checkSchoolAddrMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">招聘人员</label>
                                    <div class="col-sm-5">
                                        <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="staffName" >
                                            <option value="" selected>请选择招聘人员</option>
                                        </select>
                                        <span class="checkMsg" id="checkStaffNameMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>

                            <div class="modal-footer">
                                <button class="btn btn-default"  data-dismiss="modal">关闭</button>
                                <%--                                <button class="btn btn-primary" id="submitBtn" onclick="summitQuestion()" >提交</button>--%>
                                <input  type="button" class="btn btn-primary" id="submitBtn" onclick="summitSchoolMessage()" value="提交">
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
