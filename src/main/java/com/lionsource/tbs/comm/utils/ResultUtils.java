package com.lionsource.tbs.comm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ReturnUtill
 * @Description 返回结果封装工具类
 * @Author 狮源信息-Sunny
 * @Date 2019/4/1 19:07
 * @Version 1.0
 **/
public class ResultUtils {
    //请求成功
    public static final int CODE_SUCCESS = 200;
    //请求失败
    public static final int CODE_REQFAIL = 500;
    //数据列表
    public static final int CODE_DATLIST = 0;

    /**
     * @Author 狮源信息-Sunny
     * @Description 返回结果
     * @Date 19:11 2019/4/1
     * @Param [code, msg, dataList] 错误码，错误消息，数据列表
     * @return
     **/
    public static Map<String, Object> toMap(int code, String msg, Object data) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("code", code);
        dataMap.put("msg", msg);
        dataMap.put("data", data);
        return dataMap;
    }

    /**
     * @Author 狮源信息-Sunny
     * @Description 返回结果
     * @Date 19:11 2019/4/1
     * @Param [code, msg, count, dataList] 错误码，错误消息，数据总数，数据列表
     * @return
     **/
    public static Map<String, Object> toMap(int code, String msg,int count, Object data) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("code", code);
        dataMap.put("msg", msg);
        dataMap.put("count",count);
        dataMap.put("data", data);
        return dataMap;
    }
}
