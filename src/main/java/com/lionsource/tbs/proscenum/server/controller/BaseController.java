package com.lionsource.tbs.proscenum.server.controller;


import com.lionsource.tbs.proscenum.server.error.BusinessException;
import com.lionsource.tbs.proscenum.server.error.EmBusinessError;
import com.lionsource.tbs.proscenum.server.response.CommonRetuenType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    @ExceptionHandler(Exception.class)
    //@ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CommonRetuenType handlerExcetion(Exception ex){
        CommonRetuenType type=new CommonRetuenType();
        Map<String,Object> map=new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException businessException=(BusinessException)ex;
            map.put("errCode",businessException.getErrCode());
            map.put("errMsg",businessException.getError());
        }else if(ex instanceof ArithmeticException){
            map.put("errCode", EmBusinessError.MATH_ERROR.getErrCode());
            map.put("errMsg",EmBusinessError.MATH_ERROR.getError());
        }else{
            map.put("errCode",EmBusinessError.UNKNOW_ERROR.getErrCode());
            map.put("errMsg",EmBusinessError.UNKNOW_ERROR.getError());
        }
        return CommonRetuenType.create(map,"fail");
    }
}
