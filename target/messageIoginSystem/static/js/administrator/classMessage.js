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
                    url: "/deleteClass",
                    type: "post",
                    async: true,
                    data: {
                        clid: data.clid
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
            $("#modalTitle").html("修改班级");
            var clid = data.clid;
            var cliname = data.cliname;
            var opentime = data.opentime;
            $("#idInput").val(clid);
            $("#className").val(cliname);
            $("#date").val(opentime);

        }else  if (obj.event === 'detail') {
            // layer.msg('ID：' + data.eid + ' 的查看操作');
            $("#myModel1").modal("show");
            var clId = data.clid;
            table.reload('idTest1', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    clId:clId
                }
            }, 'data');
        }
    });

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
                    array.push(data[i].clid)
                }
                $.ajax({
                    url: "/deleteClassSome",
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

    // table.on('tool(demo)', function(obj) {
    //     var data = obj.data;
    //     if (obj.event === 'detail') {
    //         // layer.msg('ID：' + data.eid + ' 的查看操作');
    //         $("#myModel1").modal("show");
    //         var clId = data.clid;
    //         table.reload('idTest1', {
    //             page: {
    //                 curr: 1 //重新从第 1 页开始
    //             }
    //             , where: {
    //                 clId:clId
    //             }
    //         }, 'data');
    //     }
    // })
});

//清空模态框的所有信息
clearModalCheckMsg = function () {
    $("#checkClassNameMsg").html("");
    $("#checkClassTimeMsg").html("");
    $("#className").val("");
    $("#date").val("");
}

//提交信息
function staffSubmit() {
    clearModalCheckMsg();
    //modal标题
    $("#modalTitle").html("新增班级");
    $("#myModel").modal("show");
}

//新信息提交
function summitStaffMessage() {

    var a = checkClassName();
    var b = checkClassTime();
    if (a == true && b == true) {
        var cliname = $("#className").val();
        var opentime = $("#date").val();
        var clid = $("#idInput").val();
        $.ajax({
            url: "/insertClass",
            type: "post",
            async: true,
            data: {
                clid: clid,
                cliname: cliname,
                opentime: opentime
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
function checkClassName() {
    var cliname = $("#className").val();
    if ("" == cliname) {
        $("#checkClassNameMsg").html("请输入名称！");
        return false;
    } else {
        $("#checkClassNameMsg").html("");
        return true;
    }
}


//验证日期
function checkClassTime() {
    var opentime = $("#date").val();
    if ("" == opentime) {
        $("#checkClassTimeMsg").html("请输入日期！");
        return false;
    } else {
        $("#checkClassTimeMsg").html("");
        return true;
    }



}