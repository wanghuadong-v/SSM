layui.use(['table', 'laydate', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    //监听工具条
    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            // layer.msg('ID：' + data.eid + ' 的查看操作');
            $("#myModel").modal("show");
            var clid = data.clid;
            var cliname = data.cliname;
            var opentime = data.opentime;
            $("#classId").val(clid);
            $("#className").val(cliname);
            $("#classTime").val(opentime);
        }
    })
});
