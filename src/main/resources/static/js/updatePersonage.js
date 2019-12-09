$(function () {
    if($(".show").val()=="修改失败"){
        swal("修改失败","提示","error");
        return false;
    }
    /**
     * 非空验证
     */
    $("#update").click(function () {
        if($(".serverProvince").val()==""||$(".money").val()==""||$(".steDescribe").val()==""){
            swal("填入不完整，请重新输入","提示","error");
            return false;
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
    /**
     * 根据编号查询推荐人的姓名
     */
    if($("#refId").text!="无"){
        var refId = $("#refId").text();
        $.ajax({
            url:"getRef_Id",
            data:{
                refId:refId
            },
            type:"post",
            success:function (data) {
                if(data!="false"){
                    $(".refName").text(data);
                }
            },
            error:function () {

            },
        })
    }
    $(".money").blur(function () {
        if(isNaN($(".money").val())){
            swal("OMG","请输入您希望的月工资","error");
            $(".money").val(3800);
            return false;
        }else if($(".money").val()<0){
            swal("OMG","工资不能为负数哦，请重新输入","error");
            $(".money").val(3800);
            return false;
        }else if($(".money").val()<1000){
            swal("OMG","工作不能低于1000元，请重新输入","error");
            $(".money").val(3800);
            return false;
        }
    })
    if($(".steWorkform").val()!=null){
        var steWorkform = $(".steWorkform").text();
        if(steWorkform=="住家"){
            $("#steWorkform").append("<span class='btn btn-warning' id='steWorkform1'>住家</span>" +
                " <span class='btn btn-type' id='steWorkform2'>钟点工</span>" +
                " <span class='btn btn-type' id='steWorkform3'>白班</span>")
        }else if(steWorkform=="钟点工"){
            $("#steWorkform").append("<span class='btn btn-type' id='steWorkform1'>住家</span>" +
                " <span class='btn btn-warning' id='steWorkform2'>钟点工</span>" +
                " <span class='btn btn-type' id='steWorkform3'>白班</span>")
        }else if(steWorkform=="白班"){
            $("#steWorkform").append("<span class='btn btn-type' id='steWorkform1'>住家</span>" +
                " <span class='btn btn-type' id='steWorkform2'>钟点工</span>" +
                " <span class='btn btn-warning' id='steWorkform3'>白班</span>")
        }
    }
    if($(".steWorkstate").val()!=null){
        var steWorkstate = $(".steWorkstate").val();
        if(steWorkstate=="雇佣中"){
            $("#steWorkstate").append("<span class='btn btn-warning' id='steWorkstate1'>雇佣中</span>" +
                " <span class='btn btn-type' disabled='disabled' id='steWorkstate2' >正在求职</span>" +
                " <span class='btn btn-type' disabled='disabled'  id='steWorkstate3'>暂不工作</span>")
        }else if(steWorkstate=="正在求职"){
            $("#steWorkstate").append("<span class='btn btn-type' disabled='disabled' id='steWorkstate1'>雇佣中</span>" +
                " <span class='btn btn-warning' id='steWorkstate2'>正在求职</span>" +
                " <span class='btn btn-type' id='steWorkstate3'>暂不工作</span>")
        }else if(steWorkstate=="暂不工作"){
            $("#steWorkstate").append("<span class='btn btn-type' disabled='disabled' id='steWorkstate1'>雇佣中</span>" +
                " <span class='btn btn-type' id='steWorkstate2'>正在求职</span>" +
                " <span class='btn btn-warning' id='steWorkstate3'>暂不工作</span>")
        }
    }
    /**
     * 根据服务类别编号查询类别名称
     */
    if($(".steWorktype").text()!=""){
        var steWorktype = $(".steWorktype").text();
        if(steWorktype[0]==","){
            var steWorktypeList = steWorktype.substr(1);
            var steName = steWorktypeList.split(",");
            for(var i = 0;i<steName.length;i++){
                var wTypeId = steName[i];
                $.ajax({
                    type: "post",
                    url:"sTypeName",
                    data:{
                        wTypeId:wTypeId,
                    },
                    success:function (wardTypeName) {
                        var $opt = $(" <span class='btn btn-warning' style='margin-right: 3px;margin-top: 3px'>"+wardTypeName+"</span>");
                        $("#workType").append($opt);
                    }
                })
            }
        }
    }
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
                // var $opt=$("<span class='btn btn-type' style='color:#fff;background-color:#f0ad4e;border-color:#eea236;margin: 5px;' id='"+"tag"+tag.tagId+"' name='tag'>"+tag.tagName+"</span>");
                var $opt=$("<span class='btn btn-type'  style='margin: 5px;' id='"+"tag"+tag.tagId+"' name='tag'>"+tag.tagName+"</span>");

                $("#steTag").append($opt);
            }
            if($(".steTag").text()!=""){
                var tag = $(".steTag").val();
                if(tag[0]==",") {
                    var msgList = tag.substr(1);
                    var msgId = msgList.split(",");
                    for (var i=0;i<msgId.length;i++){
                        var msgID = msgId[i];
                        $('#tag'+msgID).removeClass("btn btn-type");
                        $("#tag"+msgID).addClass("btn btn-warning");
                        }
                    }
                }},
            error:function (response) {
            console.log("出现错误");
        }
    })
    $("#steTag").on("click","span",function(e){
        var steTag = $(".steTag").val();
       var steTagId =  $(this).attr("id");
       var tagId = steTagId.split("tag");
        //添加
       if($("#"+steTagId).hasClass("btn btn-type")){
           $("#"+steTagId).removeClass("btn btn-type");
           $("#"+steTagId).addClass("btn btn-warning");
           $(".steTag").text(steTag+tagId);
           var x = $(".steTag").val();
           var y = x.split(",");
           var z = y.sort(function(a,b){return a-b});
           $(".steTag").val(z);
       }else if($("#"+steTagId).hasClass("btn btn-warning")){
           //删除
           $("#"+steTagId).removeClass("btn btn-warning");
           $("#"+steTagId).addClass("btn btn-type");
           var tName = steTag.replace(tagId,' ');
           $(".steTag").val(tName);
           var x = $(".steTag").val();
           var y = x.split(",");
           var z = y.sort(function(a,b){return a-b});
           $(".steTag").val(z);
       }
    });
    //选择工作形式
    $("#steWorkform").on("click","span",function(e){
        debugger;
       var workTd = $(this).attr("id");
       if(workTd=="steWorkform1"){
           $("#"+workTd).removeClass("btn btn-type");
           $("#"+workTd).addClass("btn btn-warning");
           if( $("#steWorkform2").hasClass("btn btn-warning")){
               $("#steWorkform2").removeClass("btn btn-warning");
               $("#steWorkform2").addClass("btn btn-type");

           }
           if( $("#steWorkform3").hasClass("btn btn-warning")){
               $("#steWorkform3").removeClass("btn btn-warning");
               $("#steWorkform3").addClass("btn btn-type");

           }
           $(".steWorkform").val("住家");
       }else if(workTd=="steWorkform2"){
           $("#"+workTd).removeClass("btn btn-type");
           $("#"+workTd).addClass("btn btn-warning");
           if( $("#steWorkform1").hasClass("btn btn-warning")){
               $("#steWorkform1").removeClass("btn btn-warning");
               $("#steWorkform1").addClass("btn btn-type");
           }
           if( $("#steWorkform3").hasClass("btn btn-warning")){
               $("#steWorkform3").removeClass("btn btn-warning");
               $("#steWorkform3").addClass("btn btn-type");
           }
           $(".steWorkform").val("钟点工");
       }else if(workTd=="steWorkform3"){
           $("#"+workTd).removeClass("btn btn-type");
           $("#"+workTd).addClass("btn btn-warning");
           if( $("#steWorkform2").hasClass("btn btn-warning")){
               $("#steWorkform2").removeClass("btn btn-warning");
               $("#steWorkform2").addClass("btn btn-type");

           }
           if( $("#steWorkform1").hasClass("btn btn-warning")){
               $("#steWorkform1").removeClass("btn btn-warning");
               $("#steWorkform1").addClass("btn btn-type");

           }
           $(".steWorkform").val("白班");
       }
    })
    //选择工作状态
    $("#steWorkstate2").click(function () {
        debugger;
        var workTd = $(this).attr("id");
        if($("#steWorkstate1").hasClass("btn btn-warning")){
        }else{
            if(workTd=="steWorkstate2") {
                $("#" + workTd).removeClass("btn btn-type");
                $("#" + workTd).addClass("btn btn-warning");
                if ($("#steWorkstate1").hasClass("btn btn-warning")) {
                    $("#steWorkstate1").removeClass("btn btn-warning");
                    $("#steWorkstate1").addClass("btn btn-type");
                }
                if ($("#steWorkstate3").hasClass("btn btn-warning")) {
                    $("#steWorkstate3").removeClass("btn btn-warning");
                    $("#steWorkstate3").addClass("btn btn-type");
                }
                $(".steWorkstate").val("正在求职");
            }
        }
    });
    $("#steWorkstate3").click(function () {
        debugger;
        var workTd = $(this).attr("id");
        if($("#steWorkstate1").hasClass("btn btn-warning")){

        }else{
            if(workTd=="steWorkstate3") {
                $("#"+workTd).removeClass("btn btn-type");
                $("#"+workTd).addClass("btn btn-warning");
                if( $("#steWorkstate2").hasClass("btn btn-warning")){
                    $("#steWorkstate2").removeClass("btn btn-warning");
                    $("#steWorkstate2").addClass("btn btn-type");
                }
                if( $("#steWorkstate1").hasClass("btn btn-warning")){
                    $("#steWorkstate1").removeClass("btn btn-warning");
                    $("#steWorkstate1").addClass("btn btn-type");
                }
                $(".steWorkstate").val("暂不工作");
            }
        }
    });

    /**
     * 请求范围省份
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