$(function(){
    $(".ref_id").blur(function () {
        var getRef_name=$(".ref_id").val();
        /**
         * 根据姓名查询推荐人是否存在
         */
        if($(".ref_id").val()!="") {
            $.ajax({
                url:"getRef_name",//请求路径
                data:{
                    getRef_name:getRef_name
                },
                success:function (result) {
                    if(result=="false"){
                        swal("OMG","推荐人不存在，请您确认后再输入","error");
                        return;
                    }else{
                        $(".ref_ids").val(result);
                    }
                }

            })
        }
    })
    $(".ste_name").blur(function () {
        if($(".ste_name").val()==""){
            swal("OMG","必填项不能为空，请输入姓名","error");
            return;
        }
    })
    $(".money").blur(function () {
        if($(".money").val()==""){
            swal("OMG","输入错误，请重新输入","error");
            return;
        }else if(isNaN($(".money").val())){
            swal("OMG","请输入您希望的月工资","error");
            return;
        }else if($(".money").val()<0){
            swal("OMG","工资不能为负数哦，请重新输入","error");
            return;
        }else if($(".money").val()<1000){
            swal("OMG","工作不能低于1000元，请重新输入","error");
            return;
        }
    })
    $(".ste_age").blur(function () {
        if($(".ste_age").val()==""){
            swal("OMG","必填项不能为空，请输入年龄","error");
            return;
        }else if($(".ste_age").val()>120||$(".ste_age")<0||isNaN($(".ste_age").val())){
            swal("OMG","年龄输入不合理，请您重新输入","error");
            return;
        }else if($(".ste_age").val()<18){
            swal("OMG","本公司不收童工，请您达到年龄要求后，再来","error");
            return;
        }
    })
    $(".ste_tel").blur(function () {
        var myreg=/^[1][0-9]{10}$/;
        if($(".ste_tel").val()==""){
            swal("OMG","必填项不能为空，请输入手机号码","error");
            return;
        }else if(!myreg.test($(".ste_tel").val())){
            swal("OMG","输入不合理，请重新输入手机号码","error");
            return;
        }
    })
    $(".ste_workyear").blur(function () {
        if($(".ste_workyear").val()==""){
            swal("OMG","必填项不能为空，请输入您工作的年限","error");
            return;
        }else if($(".ste_workyear").val()>80||$(".ste_workyear")<0||isNaN($(".ste_workyear").val())){
            swal("OMG","工作的年限输入不合理，请您重新输入","error");
            return;
        }
    })
    $(".ste_describe").blur(function () {
        if($(".ste_describe").val()==""){
            swal("OMG","必填项不能为空，请输入您的个人介绍","error");
            return;
        }
    })
    $(".ste_address").blur(function () {
        if($(".ste_address").val()==""){
            swal("OMG","必填项不能为空，请输入您的常驻地址","error");
            return;
        }else if(!isNaN($(".ste_address").val())){
            swal("OMG","您输入的不合理，请您重新输入常驻地址","error");
            return;
        }
    })
    $(".minus").bind("click",function(){

        var number = $(".money").val();
        var count = number-100;
        if(number<=1000){
            swal("OMG!", "工资不能低于1000元！！！", "error");
            return;
            number=1000;
        }
        $(".money").val(count);
    })
    $(".add").bind("click",function(){
        var numberOne = $(".money").val();
        var countO = +numberOne+100;
        $(".money").val(countO);
    })
    $.ajax({
        dataType:"json",
        url:"stewardtype",//请求路径
        success:function (reponse){
            var stewardtypeArr = reponse.stewardtypeList;
            for(var i in stewardtypeArr){
                var stewardtype=stewardtypeArr[i];
                var $opt=$("<input  value='"+stewardtype.stName+"' id='"+stewardtype.stId+"'   type='button' name='stewardtype' style='margin: 20px 10px;  ' >");
                $(".button").append($opt);
            }

        },
        error:function (response) {
            console.log("出现错误");
        }
    })
    var i = 0;
    $(".button").on("click","input",function(e){
        var ste_worktype=$(".ste_worktype").val();
        var stewardtype =  $(this).attr("id");
        if(i++%2==0){
            document.getElementById(stewardtype).style.backgroundColor="#F39800";
            $(".ste_worktype").val(ste_worktype+stewardtype+",");
        }else{
            document.getElementById(stewardtype).style.backgroundColor="#E2E2E2";
            var s = ste_worktype.replace(stewardtype+",",'');
            $(".ste_worktype").val(s);
        }

    });
    /**
     * 查询所有的个人标签
     */
    $.ajax({
        dataType:"json",
        url:"tagAll",//请求路径
        success:function (reponse){
            var tagArr = reponse.tagList;
            for(var i in tagArr){
                var tag=tagArr[i];
                var $opt=$("<input value='"+tag.tagName+"' id='"+"tag"+tag.tagId+"' type='button' name='tag' style='margin: 20px 10px;'/>");
                $(".button1").append($opt);
            }
        },
        error:function (response) {
            console.log("出现错误");
        }
    })

    var gr=0;
    $(".button1").on("click","input",function (e) {
        var ste_tag = $(".ste_tag").val();
        var stetag = $(this).attr("id");
        var name = stetag.replace("tag","");
        if(gr++%2==0){
            document.getElementById(stetag).style.backgroundColor="#F39800";
            $(".ste_tag").val(ste_tag+name+",");
        }else{
            document.getElementById(stetag).style.backgroundColor="#E2E2E2";
            var s = ste_tag.replace(name+",","");
            $(".ste_tag").val(s);
        }
    })
    /**
     * 请求服务范围省份
     */
    $.ajax({
        dataType:"json",
        url:"getProvinceCity",//请求路径
        success:function (reponse){
            var provinArr = reponse.provinList;
            for(var i in provinArr){
                var provin=provinArr[i];
                var option=$("<option value='"+provin.provId+"'>"+provin.provName+"</option>");
                $(".serverProvince").append(option);
            }
        },
        error:function (response) {
            console.log("出现错误");
        }
    })
    /**
     * 请求服务范围省份城市二级联动
     */
    $(".serverProvince").change(function() {
        //console.log($(this).val());
        //this 表示当前的 js 对象  ---jq对象
        var provinceValue = $(this).val();
        //需要把 city的下拉框清空  //gt 大于0的
        $(".serverCity option:gt(0)").remove();
        //$.get() $.post()..
        $.ajax({
            url: 'getProCity',
            dataType: 'json',
            data: {
                proId: provinceValue
            },
            success: function (response) {
                //往 city select 中 append
                var cityList = response.cityList;
                for (var i = 0; i < cityList.length; i++) {
                    var city = cityList[i];
                    //创建 option
                    var $opt = $("<option value='" + city.cityId + "'>" + city.cityName + "</option>");
                    $(".serverCity").append($opt);
                }
            }
        })
    })

        //手机验证码
        document.getElementById("btn").onclick=function(){time(this);}
        $("#btn").click(function () {
            var telphone = $("#telphone").val();
            if (telphone == null || telphone == '') {
                layer.open({
                    title: '提示'
                    ,content: '请填写您的手机号码'
                });
                return false;
            }
            //发送ajax的请求
            $.ajax({
                method: "POST",
                url: "getphone",
                data: {
                    telphone: telphone
                },
                //xhrFields: { withCredential s: true },
                success: function (data) {
                    if (data.status == "success") {
                        layer.open({
                            title: '提示'
                            ,content: '验证码发送成功，请在手机上查收'
                        });
                    } else {
                        /* BusinessException */
                        alert("验证码发送失败,原因是:" + data.data.errMsg);
                    }
                },
                error: function (data) {
                    alert("服务器异常,原因是:" + data.responseText);
                }
            });
        })
        //可以阻止冒泡
        return false;
        //验证用户名是否重复
    $("#userName").blur(function () {
        var name = $("#userName").val();
        if(name==null||name==''){
            layer.msg('用户名不能为空', {icon: 5});
            return false;
        }
        //发送ajax的请求
        $.ajax({
            type: "POST",
            url: "checkUser",
            data: {
                "tername": name,
            },
            success: function (data) {
                if (data=="true") {
                } else {
                    /* BusinessException */
                    layer.open({
                        title: '提示'
                        ,content: '用户名已经被占用'
                    });
                }
            }
        });
        //可以阻止冒泡
        return false;
    })
    var wait=60;
    function time(o) {
        if (wait == 0) {
            o.removeAttribute("disabled");
            o.value="获取验证码";
            wait = 60;
        } else {
            o.setAttribute("disabled", true);
            o.value="重新发送(" + wait + ")";
            wait--;
            setTimeout(function() {
                time(o)
            },1000)
        }
    }
})