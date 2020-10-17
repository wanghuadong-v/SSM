layui.use(['table', 'laydate', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    //监听工具条
    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            // layer.msg('ID：' + data.eid + ' 的查看操作');
            $("#myModel").modal("show");
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
    })
});
