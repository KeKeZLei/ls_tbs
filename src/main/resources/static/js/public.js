//标准模态对话框[obj-要刷新数据的元素；title-标题；url-显示页面；data-渲染数据；width-宽；height-高]
function modalDialog(obj,title,url,width,height,data) {
    top.layer.open({
        type: 2 //此处以iframe举例
        , title: title
        , area: [width, height]
        , shade: 0.8
        , maxmin: true
        , content: url
        , zIndex: layer.zIndex //重点1
        , success: function (layero, index) {
            top.layer.setTop(layero); //重点2
            if (data != null) {
                layero.find("iframe")[0].contentWindow.renderData(data);
            }
        }
        , end: function () {
            if (obj != null && obj != 'undefined') {
                obj.reload();
            }
        }
    });
}

function initEditor(){
    var editor = new wangEditor('#editor');
    editor.customConfig.uploadImgServer = "uploadEditor";
    editor.customConfig.uploadFileName = 'file';
    editor.customConfig.pasteFilterStyle = false;
    editor.customConfig.uploadImgMaxLength = 5;
    editor.customConfig.uploadImgHooks = {
        // 上传超时
        timeout: function (xhr, editor) {
            layer.msg('上传超时！')
        },
        // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        customInsert: function (insertImg, result, editor) {
            if (result.code == 200) {
                var data = result.data;
                insertImg(data.tagFilePath + "&type=5");
            } else {
                layer.msg(result.msg);
            }
        }
    };
    editor.customConfig.customAlert = function (info) {
        layer.msg(info);
    };
    editor.create();

    return editor;
}

//时间处理
function formatTime(time) {
    //以空格分隔后的结果
    var str = time.split(" ");
    return str[1];
}

//日期处理
function formatDate(date) {
    //以空格分隔后的结果
    var str = date.split(" ");
    return str[0];
}

//验证身份证号码是否正确
function isIDCard(str) {
    var arry = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙古",
        21: "辽宁",
        22: "吉林",
        23: "黑龙江 ",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北 ",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏 ",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外 "
    };
    //身份证号码正则表达式
    var idCardReg = /(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    //18位身份证需要验证最后一位校验位
    var code = str.split('');
    //∑(ai×Wi)(mod 11)
    //加权因子
    var factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
    //校验位
    var parity = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
    var sum = 0;
    var ai = 0;
    var wi = 0;
    for (var i = 0; i < 17; i++) {
        ai = code[i];
        wi = factor[i];
        sum += ai * wi;
    }
    if (idCardReg.test(str) && arry[str.substring(0, 2)] && parity[sum % 11] == code[17]) {
        return true;
    } else {
        return false;
    }
}