package com.lionsource.tbs.proscenum.server.response;

import lombok.Data;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/24 0024 下午 8:06
 * @Version 1.0
 */
@Data
public class CommonRetuenType {
    private String status;
    private Object data;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonRetuenType create(Object data){
        return create(data,"success");
    }
    public static CommonRetuenType create(Object data,String status){
        CommonRetuenType type=new CommonRetuenType();
        type.setData(data);
        type.setStatus(status);
        return type;
    }
}
