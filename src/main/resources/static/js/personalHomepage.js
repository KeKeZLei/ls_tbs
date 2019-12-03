$(function () {
    // if($(".msg").text()!=""){
    //     swal("登录成功","提示","success");
    // }
    if($(".tag").text()!=null){
        var tag = $(".tag").text();
        if(tag[0]==","){
            var msgList = tag.substr(1);
            var msgId = msgList.split(",");
            for (var i=0;i<msgId.length;i++){
                var msgID = msgId[i];
                $.ajax({
                    type:"post",
                    data:{
                        msgID:msgID
                    },
                    url:"tagGetId",
                    success:function (tagName) {
                        // alert(tagName);
                        var $opt = $("<span class='btn btn-warning' style='margin: 10px;'>"+tagName+"</span>");
                        $(".tagName").append($opt);
                    },
                })
            }
        }
    }
})