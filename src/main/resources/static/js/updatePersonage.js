$(function () {
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
            return false;
        }else if($(".money").val()<0){
            swal("OMG","工资不能为负数哦，请重新输入","error");
            return false;
        }else if($(".money").val()<1000){
            swal("OMG","工作不能低于1000元，请重新输入","error");
            return false;
        }
    })
    if($(".steWorkform").text!=null){
        var steWorkform = $(".steWorkform").text();
        if(steWorkform=="住家"){
            $("#steWorkform").append("<span class='btn btn-warning'>住家</span>" +
                " <span class='btn btn-type'>钟点工</span>" +
                " <span class='btn btn-type'>白班</span>")
        }else if(steWorkform=="钟点工"){
            $("#steWorkform").append("<span class='btn btn-type'>住家</span>" +
                " <span class='btn btn-warning'>钟点工</span>" +
                " <span class='btn btn-type'>白班</span>")
        }else if(steWorkform=="白班"){
            $("#steWorkform").append("<span class='btn btn-type'>住家</span>" +
                " <span class='btn btn-type'>钟点工</span>" +
                " <span class='btn btn-warning'>白班</span>")
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
})