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
                    url: "/deleteSchool",
                    type: "post",
                    async: true,
                    data: {
                        id: data.id
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
            var id = data.id;
            var uname = data.uname;
            var uaddr = data.uaddr;
            var ename = data.ename;
            $("#idInput").val(id);
            $("#schoolName").val(uname);
            $("#schoolAddr").val(uaddr);
            // $("#staffName").val(ename);
            //下拉框取值
            var staffName = $("#staffName option");
            for (var i = 0; i <staffName.length ; i++) {
               var staffNames = staffName[i].text;
               if (ename === staffNames){
                  $( staffName[i]).prop("selected",true);
                   return;
               }
            }
        }
    });

    //查询
    schoolCheck = function () {
        var selectSchoolId = $('#selectSchoolId').val();
        //执行重载
        table.reload('idTest', {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            ,where: {
                uname: selectSchoolId
            }
        }, 'data');
    };

    schoolSomeDel =function() {
    var  checkStatus = table.checkStatus('idTest')
            , data = checkStatus.data;
    if (data.length === 0){
        layer.alert("请选择至少一项进行删除")
    }else {
        layer.alert("确定要删除吗？",function (index) {
            var array = new Array();
            for (var i = 0; i <data.length ; i++) {
                array.push(data[i].id)
            }
            $.ajax({
                url:"/deleteSchoolSome",
                type:"post",
                data:{
                    ids:array
                },
                dataType:"text",
                success:function (msg) {
                    window.location.reload();
                    if (msg !== "true" && msg !== true){
                        array("删除失败");
                    }

                },
                error:function () {
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
getStaffName();
});
function getStaffName(){
    $.ajax({
        url:"/getStaffName",
        type:"get",
        dataType:"json",
        success:function (data) {
            // console.log(data);
            for (var i = 0; i < data.length; i++) {
                //拼接下拉框
                var newOption =  "<option value=" + data[i].eid + ">" + data[i].ename + "</option>";

                $("#staffName option:last").after($(newOption));
            }
        },
        error:function () {
            console.log("查询出错！")
        }

    })
}


//清空模态框的所有信息
clearModalCheckMsg = function () {
    $("#checkSchoolNameMsg").html("");
    $("#checkSchoolAddrMsg").html("");
    $("#schoolName").val("");
    $("#schoolAddr").val("");
    $("#staffName").val("");
    $("#idInput").val("");
}

//提交信息
function schoolSubmit() {
    clearModalCheckMsg();
    //modal标题
    $("#modalTitle").html("信息添加");
    $("#myModel").modal("show");
}

//新信息提交
function summitSchoolMessage() {

    var a = checkSchoolName();
    var b = checkSchoolAddr();
    // var c = checkStaffName1();
    if (a == true && b == true ) {
        var uname = $("#schoolName").val();
        var uaddr = $("#schoolAddr").val();
        var eid = $("#staffName").val();
        var id = $("#idInput").val();
        $.ajax({
            url: "/insertSchool",
            type: "post",
            async: true,
            data: {
                id:id,
                eid:eid,
                uname:uname,
                uaddr:uaddr
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
function checkSchoolName() {
    var uname = $("#schoolName").val();
    if ("" == uname) {
        $("#checkSchoolNameMsg").html("请输入名称！");
        return false;
    } else {
        $("#checkSchoolNameMsg").html("");
        return true;
    }
}


//验证地址
function checkSchoolAddr() {
    var uaddr = $("#schoolAddr").val();
    if ("" == uaddr) {
        $("#checkSchoolAddrMsg").html("请输入地址！");
        return false;
    } else {
        $("#checkSchoolAddrMsg").html("");
        return true;
    }
}
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