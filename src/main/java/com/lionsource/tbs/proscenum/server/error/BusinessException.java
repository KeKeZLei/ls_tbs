package com.lionsource.tbs.proscenum.server.error;

//自定义异常类，处理业务逻辑
public class BusinessException extends Exception implements CommonError{
    //一定要能够和EmusiinessError相关联
    private CommonError commonError;
    public  BusinessException (CommonError commonError,String errorMsg){
        super();//没写将无法使用父类的一些属性
        this.commonError=commonError;
        this.commonError.setErrorMsg(errorMsg);
    }
    public BusinessException(CommonError commonError){
        super();
        this.commonError=commonError;
    }
        @Override
    public int getErrCode() {
        return commonError.getErrCode();
    }

    @Override
    public String getError() {
        return commonError.getError();
    }

    @Override
    public CommonError setErrorMsg(String errMsg) {
        commonError.setErrorMsg(errMsg);
        return this;
    }
}
