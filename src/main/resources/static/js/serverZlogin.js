$(function () {
    if($(".tisi").val()=="登录失败"){
        swal("OMG","登录失败，请您重新登录","error");
        return false;
    }
    /**
     * 点击看不清，切换验证码
     */
    $("#yzm").click(function () {
        $.ajax({
            url:"../getimage",
            success:function (data) {
                $("#yanzheng").attr("src","../getimage");
            },
            error:function () {

            }
        })
    })

    $("#submitBtn").click(function () {
        if($("#ste_name").val()==""||$("#ste_tel").val()==""||$("#yzCode").val()=="") {
            swal("OMG", "登录信息不能为空，请您填写完成", "error");
            return false;
        }else if($("#yzCode").val!=""){
            var yzCode =  $("#yzCode").val();
            $.ajax({
                url:"../serverImages",
                type:"post",
                data:{yzCode:yzCode},
                success:function (data) {
                    if(data=="false"){
                        swal("OMG","输入的验证码不一致，请重新输入","error");
                        return false;
                    }},
            })
        }
    })

    $(".ste_tel").blur(function () {
        var myreg=/^[1][0-9]{10}$/;
        if(!myreg.test($(".ste_tel").val())){
            swal("OMG","输入不合理，请重新输入手机号码","error");
            return false;
        }
    })
    /**
     * 判断图片验证码是否一致
     */
    $("#yzCode").blur(function () {
        if($("#yzCode").val()!=""){
           var yzCode =  $("#yzCode").val();
           $.ajax({
               url:"../serverImages",
               type:"post",
               data:{yzCode:yzCode},
               success:function (data) {
                    if(data=="false"){
                        swal("OMG","输入的验证码不一致，请重新输入","error");
                        return false;
                    }
               },
           })
        }
    })
})