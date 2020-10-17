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
                                    <label class="col-sm-2" style="display: inline-block">负责人姓名</label>
                                    <div class="col-sm-5" >
<%--                                        <input type="text" id="idInput" style="display: none">--%>
                                        <input type="text" class="layui-input" id="leaderName" onblur="checkLeaderName()">
                                        <span class="checkMsg" id="checkLeaderNameMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
<%--                            <div class="row">--%>
<%--                                <div class="form-group">--%>
<%--                                    <label class="col-sm-2" style="display: inline-block">单选框</label>--%>
<%--                                    <div class="col-sm-5" >--%>
<%--                                        <div  id="leaderSex">--%>
<%--                                        <input type="radio" name="sex" value="男" title="男" checked="" >男--%>
<%--                                        <input type="radio" name="sex" value="女" title="女">女--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <br/>--%>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2" style="display: inline-block">性别</label>
                                    <div class="col-sm-5" >
<%--                                        <input type="text" id="idInput" style="display: none">--%>
                                        <input type="text" class="layui-input" id="leaderSex" onblur="checkLeaderSex()">
                                        <span class="checkMsg" id="checkLeaderSexMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2" style="display: inline-block">联系电话</label>
                                    <div class="col-sm-5" >
<%--                                        <input type="text" id="idInput" style="display: none">--%>
                                        <input type="text" class="layui-input" id="leaderTel" onblur="checkLeaderTel()">
                                        <span class="checkMsg" id="checkLeaderTelMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">职位</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="layui-input" id="leaderJob" onblur="checkLeaderJob()">
                                        <span class="checkMsg" id="checkLeaderJobMsg"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-sm-2">所属高校</label>
                                    <div class="col-sm-5">
                                        <select name="eqptType" lay-filter="eqptType" class="layui-input"  id="schoolName"onblur="checkSchoolName1()" >
                                            <option value="" selected>请选择高校</option>
                                        </select>
                                        <span class="checkMsg" id="checkSchoolNameMsg1"></span>
                                    </div>
                                </div>
                            </div>
                            <br/>

                            <div class="modal-footer">
                                <button class="btn btn-default"  data-dismiss="modal">关闭</button>
                                <%--                                <button class="btn btn-primary" id="submitBtn" onclick="summitQuestion()" >提交</button>--%>
                                <input  type="button" class="btn btn-primary" id="submitBtn" onclick="summitLeaderMessage()" value="提交">
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
