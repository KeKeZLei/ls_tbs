package com.lionsource.tbs.comm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description 返回结果封装工具类
 *
 **/
public class ResultUtils {
    //请求成功
    public static final int CODE_SUCCESS = 200;
    //请求失败
    public static final int CODE_REQFAIL = 500;
    //数据列表
    public static final int CODE_DATLIST = 0;

    /**
     * @Description 返回结果
     **/
    public static Map<String, Object> toMap(int code, String msg, Object data) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("code", code);
        dataMap.put("msg", msg);
        dataMap.put("data", data);
        return dataMap;
    }

    /**
     * @Description 返回结果
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
