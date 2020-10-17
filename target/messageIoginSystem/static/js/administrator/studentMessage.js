layui.use(['table', 'laydate', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;

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


//批量分班
//     selectClass = function () {
//         var checkStatus = table.checkStatus('idTest')
//             , data = checkStatus.data,
//             clid = "";
//         //  layer.alert(JSON.stringify(data));
//
//         if (data.length === 0) {
//             layer.alert("至少一项")
//         } else {
//             layer.alert("确定要分班吗？", function (index) {
//                 var array = new Array();
//                 for (var i = 0; i < data.length; i++) {
//                     array.push(data[i].sid)
//                 }
//                 $.ajax({
//                     url: "/selectStudentSome",
//                     type: "post",
//                     data: {
//                         ids: array,
//                         clid:clid
//                     },
//                     dataType: 'text',
//                     success: function (msg) {
//                         window.location.reload();
//                         if (msg !== 'true' && msg !== true) {
//                             alert("修改失败！");
//                         }
//                     },
//                     error: function () {
//                         console.log("修改错误！")
//                     }
//                 })
//             })
//         }
//     };










});