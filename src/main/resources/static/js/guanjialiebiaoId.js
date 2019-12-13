$(function () {
    /**
     * 根据服务类别编号查询类别名称
     */
    if($(".steId").text()!=""){
        var steId = $(".steId").text();
        var ceslaz = $(".cesla").text();
        if(steId[0]==","){
           debugger
            for(var j=0;j<ceslaz.length;j++){
               var bh= parseInt(ceslaz.substring(j,j+1));
                var steId = $(".steId").eq(bh).text();
                var steIdList = steId.substr(1);
                var steName = steIdList.split(",");

            for(var i = 0;i<steName.length;i++){
                var steIds = steName[i];
                $.ajax({
                    type: "post",
                    data:{
                        steIds:steIds,
                    },
                    url:"TagNames",
                    success:function (steNames) {
                        var $opt=null;
                        // if(i<3){
                        //     $opt = (" <span class='btn btn-info'>"+steNames+"</span>");0
                        //     //$(".cesla").eq(bh).append($opt);
                        // }
                        // if(i>3 && i<5){
                        //     $opt = (" <span class='btn btn-warning'>"+steNames+"</span>");
                        //     //$(".cesla").eq(bh).append($opt);
                        // }
                        // if (i>5) {
                        $opt = (" <span class='btn btn-success'>"+steNames+"</span>");
                        // }
                        $(".cesla").eq(bh).append($opt);
                    }
                })

            }

            }//大循环
        }
    }
})