package com.lionsource.tbs.proscenum.serverD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestControllers {
    @RequestMapping("/test")
    public String test(HttpServletRequest request){
        return "serverZ/test";
    }

    @RequestMapping("/tuijianren")
    public String tuijianren(HttpServletRequest request){
        return "serverZ/tuijianrenduan";
    }

    @RequestMapping("/guanjialiebiao")
    public String guanjialiebiao(HttpServletRequest request){
        return "serverZ/guanjialiebiao";
    }

    @RequestMapping("/guanjialiebiaosm")
    public String guanjialiebiaosm(HttpServletRequest request){
        return "serverZ/guanjialiebiaosm";
    }

    @RequestMapping("/tuijianguanjia")
    public String tuijianguanjia(HttpServletRequest request){
        return "serverZ/tuijianguanjia";
    }

    @RequestMapping("/yonghu")
    public String yonghu(HttpServletRequest request){
        return "serverZ/yonghu";
    }

    @RequestMapping("/yonghusm")
    public String yonghusm(HttpServletRequest request){
        return "serverZ/yonghusm";
    }
    @RequestMapping("/registertuijianren")
    public String registertuijianren(HttpServletRequest request){
        return "serverZ/registertuijianren";
    }

    @RequestMapping("/guanjiapingjia")
    public String guanjiapingjia(HttpServletRequest request){
        return "serverZ/guanjiapingjia";
    }


    @RequestMapping("/pingjiayemian")
    public String pingjiayemian(HttpServletRequest request){
        return "serverZ/pingjiayemian";
    }

}
