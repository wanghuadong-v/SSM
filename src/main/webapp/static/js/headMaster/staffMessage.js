layui.use(['table', 'laydate', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    //监听工具条
    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            // layer.msg('ID：' + data.eid + ' 的查看操作');
            $("#myModel").modal("show");
            var eid = data.eid;
            var ename = data.ename;
            var tel = data.tel;
            $("#staffId").val(eid);
            $("#staffName").val(ename);
            $("#staffTel").val(tel);
        }
    })
});
