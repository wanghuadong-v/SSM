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
                    url: "/deleteStudent",
                    type: "post",
                    async: true,
                    data: {
                        sid: data.sid
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
            var sid = data.sid;
            var sname = data.sname;
            var tel = data.tel;
            var uname = data.uname;
            var state = data.state;
            var cliname = data.cliname;
            $("#idInput").val(sid);
            $("#staffName").val(sname);
            $("#staffTel").val(tel);
            // $("#schoolName").val(clId);
            $("#studentState").val(state);
            var schoolName = $("#schoolName option");
            for (var i = 0; i <schoolName.length ; i++) {
                var schoolNames = schoolName[i].text;
                if (uname === schoolNames){
                    $(schoolName[i]).prop("selected",true);
                }
            }
            var className = $("#className option");
            for (var i = 0; i <className.length ; i++) {
                var classNames = className[i].text;
                if (cliname === classNames){
                    $(className[i]).prop("selected",true);
                    return;
                }
            }
        }
    });

    staffCheck = function () {
        var selectStaffName = $('#selectStaffName').val();
        //执行重载
        table.reload('idTest', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            , where: {
                sname: selectStaffName,
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
                    array.push(data[i].sid)
                }
                $.ajax({
                    url: "/deleteStudentSome",
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
//下拉框
$(function () {
    getSchoolName();
    getClassName();
});

function getSchoolName(){
    $.ajax({
        url:"/getSchoolName1",
        type:"get",
        dataType:"json",
        success:function (data) {
            // console.log(data);
            for (var i = 0; i < data.length; i++) {
                //拼接下拉框
                var newOption =  "<option value=" + data[i].id + ">" + data[i].uname + "</option>";

                $("#schoolName option:last").after($(newOption));
            }
        },
        error:function () {
            console.log("查询出错！")
        }

    })
}


function getClassName(){
    $.ajax({
        url:"/getClassName1",
        type:"get",
        dataType:"json",
        success:function (data) {
            // console.log(data);
            for (var i = 0; i < data.length; i++) {
                //拼接下拉框
                var newOption =  "<option value=" + data[i].clid + ">" + data[i].cliname + "</option>";

                $("#className option:last").after($(newOption));
            }
        },
        error:function () {
            console.log("查询出错！")
        }

    })
}



//清空模态框的所有信息
clearModalCheckMsg = function () {
    $("#checkStaffNameMsg").html("");
    $("#checkStaffTelMsg").html("");
    $("#checkSchoolNameMsg").html("");
    $("#checkStudentStatebMsg").html("");
    $("#checkClassNameMsg").html("");
    $("#staffName").val("");
    $("#staffTel").val("");
    $("#schoolName").val("");
    $("#studentState").val("");
    $("#className").val("");
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
    var c = checkStaffJob();
    var d = checkStudentState();
    var e =  checkClass();
    if (a == true && b == true && c == true && d == true && e ==true) {
        var sname = $("#staffName").val();
        var tel = $("#staffTel").val();
        var id = $("#schoolName").val();
        var state = $("#studentState").val();
        var sid = $("#idInput").val();
        var clId = $("#className").val();
        $.ajax({
            url: "/insertStudent",
            type: "post",
            async: true,
            data: {
                sid: sid,
                sname: sname,
                tel: tel,
                id: id,
                state: state,
                clId:clId
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
        $("#checkStaffTelMsg").html("");
        return true;
    }
}

//验证学校
function checkStaffJob() {
    var school = $("#schoolName").val();
    if ("" == school) {
        $("#checkSchoolNameMsg").html("请选择高校！");
        return false;
    } else {
        $("#checkSchoolNameMsg").html("");
        return true;
    }
}

//验证状态
function checkStudentState() {
    var state = $("#studentState").val();
    if ("" == state) {
        $("#checkStudentStatebMsg").html("请选择状态！");
        return false;
    } else {
        $("#checkStudentStatebMsg").html("");
        return true;
    }

}
//验证班级
function  checkClass () {
    var class1 = $("#className").val();
    if ("" == class1) {
        $("#checkClassNameMsg").html("请选择班级！");
        return false;
    } else {
        $("#checkClassNameMsg").html("");
        return true;
    }
}