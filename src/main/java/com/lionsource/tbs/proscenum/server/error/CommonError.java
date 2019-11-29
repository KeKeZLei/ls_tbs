package com.lionsource.tbs.proscenum.server.error;

public interface CommonError {
    //获取当前报错的错误码
    public int getErrCode();
    //获取错误信息
    public String getError();
    //自定义异常的设置
    public  CommonError setErrorMsg(String errMsg);
}
