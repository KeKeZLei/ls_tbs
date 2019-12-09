$(function () {
    if($(".show1").val()=="修改成功"){
        swal("修改成功","提示","success");
        return true;
    }
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