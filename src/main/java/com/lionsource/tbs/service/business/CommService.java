package com.lionsource.tbs.service.business;

/**
 *  通用业务处理接口
 *
 **/
public interface CommService {
    //分隔符
    public static final String SEPARATOR  = ";";
    public static final String COMMA = ",";
    public static final String MINUS = "-";
    //短信配置
    public static final String MSG_NAME = "MSG_NAME";
    public static final String MSG_DOMAIN = "MSG_DOMAIN";
    public static final String MSG_APPID = "MSG_APPID";
    public static final String MSG_APPKEY = "MSG_APPKEY";
    public static final String MSG_ENDPOINTNAME = "MSG_ENDPOINTNAME";
    public static final String MSG_REGIONID = "MSG_REGIONID";
    public static final String MSG_SIGNNAME = "MSG_SIGNNAME";
    public static final String MSG_CHANGEMOD = "MSG_CHANGEMOD";
    public static final String MSG_CHANGEPARAM = "MSG_CHANGEPARAM";
    public static final String MSG_SUBMOD = "MSG_SUBMOD";
    public static final String MSG_SUBPARAM = "MSG_SUBPARAM";
    public static final String MSG_PAYMOD = "MSG_PAYMOD";
    public static final String MSG_PAYPARAM = "MSG_PAYPARAM";
    public static final String MSG_USEMOD = "MSG_USEMOD";
    public static final String MSG_USEPARAM = "MSG_USEPARAM";

    /**
     * @Author 狮源信息-Sunny
     * @Description 发送websocket消息到页面
     * @Date 13:44 2019/5/14
     * @Param
     * @return
     **/
    void sendMsgToPage(String code);

    /**
     * @Author 狮源信息-Sunny
     * @Description 图标路径处理
     * @Date 14:34 2019/8/19
     * @Param [imgName,type]图片名称，图片类型(1=LOGO图片，2=头像图片，3=Banner图片，4=新闻图片，5=证书图片，6=需要审核的图片，7=富文本图片)
     * @return
     **/
     String getImagePath(String imgPath, Integer type);

    /**
     * @Author 狮源信息-Sunny
     * @Description 删除富文本图片
     * @Date 12:28 2019/9/2
     * @Param [content] 富文本内容
     * @return
     **/
    void deleteRichImg(String content);
}
