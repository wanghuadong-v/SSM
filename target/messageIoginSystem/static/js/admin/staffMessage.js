layui.use(['table', 'laydate', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    //监听工具条


    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定删除吗？', function (index) {
                obj.del();
                layer.close(index);
                $.ajax({
                    url: "/deleteStaff",
                    type: "post",
                    async: true,
                    data: {
                        eid: data.eid
                    },
                    dataType: "text",
                    success: function (msg) {
                        window.location.reload();
                        if (msg !== 'true' && msg !== true) {
                            alert("删除失败！");
                        }
                    },
                    error: function () {
                        console.log("删除错误！")
                    }
                });
                window.location.reload();
            });
        } else if (obj.event === 'edit') {
            clearModalCheckMsg();
            $("#myModel").modal("show");
            $("#modalTitle").html("信息编辑");
            var eid = data.eid;
            var ename = data.ename;
            var tel = data.tel;
            var job = data.job;
            var password = data.password;
            $("#idInput").val(eid);
            $("#staffName").val(ename);
            $("#staffTel").val(tel);
            $("#staffJob").val(job);
            $("#staffPwd").val(password);

        }
    });

    staffCheck = function () {
        var selectStaffId = $('#selectStaffId').val();
        var selectStaffName = $('#selectStaffName').val();
        var selectStaffJob = $('#selectStaffJob').val();
        //执行重载
        table.reload('idTest', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            , where: {
                eid: selectStaffId,
                ename: selectStaffName,
                job: selectStaffJob
            }
        }, 'data');
    };

//批量删除
    staffSomeDel = function () {
        var checkStatus = table.checkStatus('idTest')
            , data = checkStatus.data;
        //  layer.alert(JSON.stringify(data));

        if (data.length === 0) {
            layer.alert("请选择至少一项进行删除")
        } else {
            layer.alert("确定要删除吗？", function (index) {
                var array = new Array();
                for (var i = 0; i < data.length; i++) {
                    array.push(data[i].eid)
                }
                $.ajax({
                    url: "/deleteStaffSome",
                    type: "post",
                    data: {
                        ids: array
                    },
                    dataType: 'text',
                    success: function (msg) {
                        window.location.reload();
                        if (msg !== 'true' && msg !== true) {
                            alert("删除失败！");
                        }
                    },
                    error: function () {
                        console.log("删除错误！")
                    }
                })
            })
        }
    };


    // $('.demoTable .layui-btn').on('click', function () {
    //     var type = $(this).data('type');
    //     active[type] ? active[type].call(this) : '';
    // });
});

//清空模态框的所有信息
clearModalCheckMsg = function () {
    $("#checkStaffNameMsg").html("");
    $("#checkStaffTelMsg").html("");
    $("#checkStaffPwdMsg").html("");
    $("#checkStaffJobMsg").html("");
    $("#checkStaffPwdMsg").html("");
    $("#staffName").val("");
    $("#staffTel").val("");
    $("#staffPwd").val("");
    $("#staffJob").val("");
    $("#idInput").val("");
}

//提交信息
function staffSubmit() {
    clearModalCheckMsg();
    //modal标题
    $("#modalTitle").html("信息添加");
    $("#myModel").modal("show");
}

//新信息提交
function summitStaffMessage() {

    var a = checkStaffName();
    var b = checkStaffTel();
    var c = checkStaffPwd();
    var d = checkStaffJob()
    if (a == true && b == true && c == true && d == true) {
        var ename = $("#staffName").val();
        var tel = $("#staffTel").val();
        var job = $("#staffJob").val();
        var password = $("#staffPwd").val();
        var eid = $("#idInput").val();
        $.ajax({
            url: "/insertStaff",
            type: "post",
            async: true,
            data: {
                eid: eid,
                ename: ename,
                tel: tel,
                job: job,
                password: password
            },
            dataType: "text"
        });
        $("#myModel").modal("hide");
        window.location.reload();
    } else {
        return false;
    }
}


//验证名称
function checkStaffName() {
    var ename = $("#staffName").val();
    if ("" == ename) {
        $("#checkStaffNameMsg").html("请输入姓名！");
        return false;
    } else {
        $("#checkStaffNameMsg").html("");
        return true;
    }
}


//验证电话
function checkStaffTel() {
    var tel = $("#staffTel").val();
    if ("" == tel) {
        $("#checkStaffTelMsg").html("请输入电话！");
        return false;
    } else {
        if (!/^[1][3,4,5,7,8][0-9]{9}$/.test(tel)) {
            $("#checkStaffTelMsg").html("请输入11位手机号！");
        } else {
            $("#checkStaffTelMsg").html("");
            return true;
        }

    }
}

//验证职位
function checkStaffJob() {
    var job = $("#staffJob").val();
    if ("" == job) {
        $("#checkStaffJobMsg").html("请选择职位！");
        return false;
    } else {
        $("#checkStaffJobMsg").html("");
        return true;
    }
}

//验证密码
function checkStaffPwd() {
    var password = $("#staffPwd").val();
    if ("" == password) {
        $("#checkStaffPwdMsg").html("请输入密码！");
        return false;
    } else {
        $("#checkStaffPwdMsg").html("");
        return true;
    }
}