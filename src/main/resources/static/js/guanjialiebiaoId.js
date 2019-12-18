$(function () {
    /**
     * 根据服务类别编号查询类别名称
     */
    if($(".steId").text()!=""){
            //职业技能
            var b  = new Array("活泼开朗","热爱生活","精通英语","育儿教育","擅长面食","擅长湘菜","生活经验","老司机");
            for(var i=0;i<100;i++){
                if($("input[name="+i+"]").length>0){
                    var str=$("input[name="+i+"]").val();
                    $("input[name="+i+"]").hide();
                    for (var j=1;j<b.length+1;j++){
                        var sear=new RegExp(j);
                        if(sear.test(str)) {
                            ($("div[name="+i+"]")).append(" <div class=\"col-lg-2\">\n" +
                                "                                <div style=\"float: left;background-color: #64B4F5; border-radius:15px; color: #FFFFFF\">\n" +
                                "                                    <h4>&nbsp;&nbsp;"+b[j-1]+"&nbsp;&nbsp;</h4>\n" +
                                "                                </div>\n" +
                                "                            </div>")
                        }
                    }
                }
            }
    }

})