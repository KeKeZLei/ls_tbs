$(function () {
    /**
     * 判断是否登录成功
     */
    if($(".tisi").val()=="登录失败"){
        swal("OMG","登录失败，请重新登录","error");
        return false;
    }else if($(".tisi").val()=="验证码错误"){
        swal("OMG","验证码错误，请重新登录","error");
        return false;
    }
    //手机验证码
    //实现60秒倒计时
    document.getElementById("btn").onclick=function(){time(this);}
    $("#submitBtn").click(function () {
        if($(".ste_tel").val()==""||$("#phonVerify").val()==""){
            swal("OMG","必填项不能为空，请您输入完整","error");
            return false;
        }
    })
    /**
     * 验证手机格式是否正确
     */
    $("#phonVerify").blur(function () {
        var myreg=/^[1][0-9]{10}$/
        if(!myreg.test($(".ste_tel").val())){
            swal("OMG","手机号码输入不合理，请重新输入","error");
            return false;
        }
    })
    /**
     * 判断短信验证码是否发送成功
     * @type {number}
     */
    $("#btn").click(function () {
        var ste_tel = $(".ste_tel").val();
        if(ste_tel==""){
            swal("OMG","必填项不能为空,请输入手机号码","error");
        }
        $.ajax({
            method:"post",
            url:"../getphone",
            data:{
                ste_tel:ste_tel
            },
            success:function (data) {
                if(data=="false"){
                    swal("OMG","抱歉，验证码发送失败，请您再次尝试","error");
                    return false;
                }else{
                    $(".yzm").val(data);
                }
            }
        })
    })
    var wait=60;
    function time(o) {
        if (wait == 0) {
            o.removeAttribute("disabled");
            o.value = "获取验证码";
            wait = 60;
        } else {
            o.setAttribute("disabled", true);
            o.value = "重新发送(" + wait + ")";
            wait--;
            setTimeout(function () {
                time(o)
            }, 1000)
        }
    }
})