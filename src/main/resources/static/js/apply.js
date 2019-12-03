$(function(){
    if($(".msg").val()=="验证码错误"){
        swal("OMG","验证码错误，请重新输入","error");
        return false;
    }else if($(".msg").val()=="注册失败"){
        swal("OMG","注册失败，请重新注册","error");
        return false;
    }
    $(".submit").click(function () {
        if($(".ste_name").val()==""||$(".ste_tel").val()==""||$(".ste_age").val()==""||$("#phonVerify").val()==""||
        $(".ste_worktype").val()==""||$(".ste_describe").val()==""
        ||$(".ste_tag").val()==""||$(".ste_address").val()==""||$(".ste_province").val()=="0"||$(".ste_city").val()=="0"){
            swal("OMG","申请表必填项不能为空，请您输入完整","error");
            return false;
        }
    })
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
    $(".money").blur(function () {
        if(isNaN($(".money").val())){
            swal("OMG","请输入您希望的月工资","error");
            return false;
        }else if($(".money").val()<0){
            swal("OMG","工资不能为负数哦，请重新输入","error");
            return false;
        }else if($(".money").val()<1000){
            swal("OMG","工作不能低于1000元，请重新输入","error");
            return false;
        }
    })
    $(".ste_age").blur(function () {
        if($(".ste_age").val()>120||$(".ste_age")<0||isNaN($(".ste_age").val())){
            swal("OMG","年龄输入不合理，请您重新输入","error");
            return false;
        }else if($(".ste_age").val()<18){
            swal("OMG","本公司不收童工，请您达到年龄要求后，再来","error");
            return false;
        }
    })
    $(".ste_tel").blur(function () {
        var myreg=/^[1][0-9]{10}$/;
        if(!myreg.test($(".ste_tel").val())){
            swal("OMG","输入不合理，请重新输入手机号码","error");
            return false;
        }
        var ste_tel = $(".ste_tel").val();
        //判断手机是否重复
        $.ajax({
            type: "POST",
            url: "checkPhone",
            data: {
                "ste_tel": ste_tel,
            },
            success: function (data) {
                if (data=="true") {
                } else {
                    /* BusinessException */
                    swal("OMG","手机号码已存在，请重新输入","error");
                    return;
                }
            }
        });
        return false;
    })
        //手机验证码
        document.getElementById("btn").onclick=function(){time(this);}
        $("#btn").click(function () {
            var ste_tel = $(".ste_tel").val();
            if(ste_tel==""){
                swal("OMG","必填项不能为空，请输入手机号码","error");
                return;
            }
            //发送ajax的请求
            $.ajax({
                method: "POST",
                url: "getphone",
                data: {
                    ste_tel: ste_tel
                },
                success: function (data) {
                    if (data == "false") {
                        swal("OMG","抱歉，验证码发送失败,请您再次尝试","error");
                        return false;
                    } else {
                        $(".yzm").val(data);
                    }
                },
            });
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
    $(".ste_workyear").blur(function () {
        if($(".ste_workyear").val()>80||$(".ste_workyear")<0||isNaN($(".ste_workyear").val())){
            swal("OMG","工作的年限输入不合理，请您重新输入","error");
            return false;
        }
    })
    $(".ste_address").blur(function () {
        if(!isNaN($(".ste_address").val())){
            swal("OMG","您输入的不合理，请您重新输入常驻地址","error");
            return false ;
        }else if($(".ste_worktype").val()!=null||$(".ste_tag").val()!=null){
            var x = $(".ste_worktype").val();
            var y = x.split(",");
            var z = y.sort(function(a,b){return a-b});
            $(".ste_worktype").val(z);
            var x1 = $(".ste_tag").val();
            var y1 = x1.split(",");
            var z1 = y1.sort(function(a,b){return a-b});
            $(".ste_tag").val(z1);
            return true;
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
            document.getElementById(stewardtype).style.backgroundColor="#E8E8E8";
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
        var tagname = stetag.replace("tag","");
        if(gr++%2==0){
            document.getElementById(stetag).style.backgroundColor="#F39800";
            $(".ste_tag").val(ste_tag+tagname+",");
        }else{
            document.getElementById(stetag).style.backgroundColor="#E8E8E8";
            var s1 = ste_tag.replace(tagname+",",'');
            $(".ste_tag").val(s1);
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

    // /**
    //  * 请求籍贯省份
    //  */
    // $.ajax({
    //     dataType:"json",
    //     url:"getProvinceCity",//请求路径
    //     success:function (reponse){
    //         var provinArr = reponse.provinList;
    //         for(var i in provinArr){
    //             var provin=provinArr[i];
    //             var option=$("<option value='"+provin.provId+"'>"+provin.provName+"</option>");
    //             $(".Province").append(option);
    //         }
    //     },
    //     error:function (response) {
    //         console.log("出现错误");
    //     }
    // })
    // /**
    //  * 请求籍贯省份城市二级联动
    //  */
    // $(".Province").change(function() {
    //     var provinceValue = $(this).val();
    //     $(".City option:gt(0)").remove();
    //     $.ajax({
    //         url: 'getProCity',
    //         dataType: 'json',
    //         data: {
    //             proId: provinceValue
    //         },
    //         success: function (response) {
    //             //往 city select 中 append
    //             var cityList = response.cityList;
    //             for (var i = 0; i < cityList.length; i++) {
    //                 var city = cityList[i];
    //                 //创建 option
    //                 var $opt = $("<option value='" + city.cityId + "'>" + city.cityName + "</option>");
    //                 $(".City").append($opt);
    //             }
    //         }
    //     })
    // })
    // /**
    //  * 请求籍贯城市区县二级联动
    //  */
    // $(".City").change(function() {
    //     var cityValue = $(this).val();
    //     $(".County option:gt(0)").remove();
    //     $.ajax({
    //         url: 'getCityCounty',
    //         dataType: 'json',
    //         data: {
    //             cityid: cityValue
    //         },
    //         success: function (response) {
    //             //往 city select 中 append
    //             var countList = response.CountList;
    //             for (var i = 0; i < countList.length; i++) {
    //                 var county = countList[i];
    //                 //创建 option
    //                 var $opt = $("<option value='" + county.counId + "'>" + county.counName + "</option>");
    //                 $(".County").append($opt);
    //             }
    //         }
    //     })
    // })
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
})