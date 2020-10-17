layui.use(['table', 'laydate', 'jquery'], function () {
    var table = layui.table;

});

summitSchoolMessage = function () {
    var a = checkStaffName();
    var b = checkStaffPwd();
    var c = checkStaffJob();
    if (a == true && b == true && c == true){
        var ename = $("#staffName").val();
        var password = $("#staffPwd").val();
        var job = $("#staffJob").val();
        $.ajax({
            url:"/login",
            type:"post",
            async: true,
            data: {
                ename: ename,
                job: job,
                password: password
            },
            dataType: "text",
            success:function (data) {
                if (data === 'false'){
                    layer.alert("密码与账号错误")
                }else {
                    window.location.href=data;
                }
            },
            error:function () {
               console.log("登录失败")
            }
        });

    }
};




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