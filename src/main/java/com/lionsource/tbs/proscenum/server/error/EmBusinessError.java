package com.lionsource.tbs.proscenum.server.error;

public enum EmBusinessError implements CommonError{
    PARAMETER_VAL_ERROR(2002,"参数错误！"),
    USER_NOT_EXIST(1001,"用户信息不存在!"),
    UNKNOW_ERROR(2001,"未知错误!"),
    MATH_ERROR(1002,"算术异常"),
            ;
    private int errcode;
    private String errMsg;
    private EmBusinessError(int errCode,String errMsg){
        this.errcode=errCode;
        this.errMsg=errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errcode;
    }

    @Override
    public String getError() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String errMsg) {
        //当前类的对象 EmBusinessError
        return this;
    }
}

