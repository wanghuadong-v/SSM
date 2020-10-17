layui.use(['table', 'laydate', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;
//监听工具条

studentCheck = function () {
    var selectSchoolName = $('#selectSchoolName').val();
    var selectClassName = $('#selectClassName').val();
    //执行重载
    table.reload('idTest', {
        page: {
            curr: 1 //重新从第 1 页开始
        }
        , where: {
            uname: selectSchoolName,
            cliname: selectClassName
        }
    }, 'data');
};
});