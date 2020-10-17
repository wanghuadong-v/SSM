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
                    url: "/deleteLeader",
                    type: "post",
                    async: true,
                    data: {
                        cid: data.cid
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
            var cid = data.cid;
            var cname = data.cname;
            var csex = data.csex;
            var tel = data.tel;
            var job = data.job;
            var uname = data.uname;
            $("#idInput").val(cid);
            $("#leaderName").val(cname);
            $("#leaderSex").val(csex);
            $("#leaderTel").val(tel);
            $("#leaderJob").val(job);
            // $("#schoolName").val(uname);
            var schoolName = $("#schoolName option");
            for (var i = 0; i <schoolName.length ; i++) {
                var schoolNames = schoolName[i].text;
                if (uname === schoolNames){
                    $(schoolName[i]).prop("selected",true);
                   return;
                }
            }
        }
    });




    //查询
    leaderCheck = function () {
        var selectSchoolId = $('#selectSchoolId').val();
        //执行重载
        table.reload('idTest', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            , where: {
                uname: selectSchoolId,
            }
        }, 'data');
    }

    leaderSomeDel = function () {
        var checkStatus = table.checkStatus("idTest"),
            data = checkStatus.data;
        if (data.length === 0){
            layer.alert("请选择至少一项进行删除")
        }else {
            layer.alert("确定要删除吗？",function (index) {
                var array = new Array();
                for (var i = 0; i <data.length ; i++) {
                    array.push(data[i].cid)
                }
                $.ajax({
                    url:"/deleteLeaderSome",
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


    }

    // $('.demoTable .layui-btn').on('click', function () {
    //     var type = $(this).data('type');
    //     active[type] ? active[type].call(this) : '';
    // });
});

//下拉框
$(function () {
    getSchoolName();
});

function getSchoolName(){
    $.ajax({
        url:"/getSchoolName",
        type:"get",
        dataType:"json",
        success:function (data) {
            console.log(data);
            for (var i = 0; i <data.length ; i++) {
                var newOption = "<option value=" + data[i].id + ">" + data[i].uname + "</option>";
                $("#schoolName option:last").after($(newOption));
            }
        },
        error:function () {
            console.log("查询出错！")
        }
    })
}

//清空模态框的所有信息
clearModalCheckMsg = function () {
    $("#checkLeaderNameMsg").html("");
    $("#checkLeaderSexMsg").html("");
    $("#checkLeaderTelMsg").html("");
    $("#checkLeaderJobMsg").html("");
    $("#checkSchoolNameMsg1").html("");
    $("#leaderName").val("");
    $("#leaderSex").val("");
    $("#leaderTel").val("");
    $("#leaderJob").val("");
    $("#schoolName").val("");
    $("#idInput").val("");
}

//提交信息
function leaderSubmit() {
    clearModalCheckMsg();
    //modal标题
    $("#modalTitle").html("信息添加");
    $("#myModel").modal("show");
}

//新信息提交
function summitLeaderMessage() {

    var a = checkLeaderName();
    var b = checkLeaderSex();
    var c = checkLeaderTel();
    var d = checkLeaderJob();
    var e = checkSchoolName1();
    if (a == true && b == true && c ==true && d == true && e == true) {
        var cname = $("#leaderName").val();
        var csex = $("#leaderSex").val();
        var tel = $("#leaderTel").val();
        var job = $("#leaderJob").val();
        var id = $("#schoolName").val();
        var cid = $("#idInput").val();
        $.ajax({
            url: "/insertLeader",
            type: "post",
            async: true,
            data: {
                cid: cid,
                cname: cname,
                csex: csex,
                tel: tel,
                job:job,
                id:id
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
function checkLeaderName() {
    var cname = $("#leaderName").val();
    if ("" == cname) {
        $("#checkLeaderNameMsg").html("请输入姓名！");
        return false;
    } else {
        $("#checkLeaderNameMsg").html("");
        return true;
    }
}


//验证性别
function checkLeaderSex() {
    var csex = $("#leaderSex").val();
    if ("" == csex) {
        $("#checkLeaderSexMsg").html("请输入性别！");
        return false;
    } else {
        if (!/^男$|^女$/.test(csex)){
            $("#checkLeaderSexMsg").html("请输入性别！");

        }else {
            $("#checkLeaderSexMsg").html("");
            return true;
        }

    }
}
    //验证电话
    checkLeaderTel = function () {
        var tel = $("#leaderTel").val();
        if ("" == tel) {
            $("#checkLeaderTelMsg").html("请输入电话！");
            return false;
        } else {
            if (!/^[1][3,4,5,7,8][0-9]{9}$/.test(tel)) {
                $("#checkLeaderTelMsg").html("请输入11位手机号！");
            } else {
                $("#checkLeaderTelMsg").html("");
                return true;
            }
        }
    };

      function checkLeaderJob() {
        var job = $("#leaderJob").val();
        if ("" == job) {
            $("#checkLeaderJobMsg").html("请输入职位！");
            return false;
        } else {
            $("#checkLeaderJobMsg").html("");
            return true;
        }
    };
function checkSchoolName1  () {
        var uname = $("#schoolName").val();
        if ("" == uname) {
            $("#checkSchoolNameMsg1").html("请选择学校！");
            return false;
        } else {
            $("#checkSchoolNameMsg1").html("");
            return true;
        }
    };

// //验证所属人员
// function checkStaffName1() {
//     var ename = $("#staffName").val();
//     if ("" == ename) {
//         $("#checkStaffNameMsg").html("请选择职位！");
//         return false;
//     } else {
//         $("#checkStaffNameMsg").html("");
//         return true;
//     }
// }