//package com.lionsource.tbs.proscenum.server.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.lionsource.tbs.comm.model.Referrer;
//import com.lionsource.tbs.proscenum.server.service.ReferrerService;
//import org.apache.http.HttpRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
///**
// * @Description
// * @Author 可可球
// * Date: Created in 2019/11/22 0022 上午 10:59
// * @Version 1.0
// */
//@Controller
//public class ReferrerController {
//    @Autowired
//    private ReferrerService referrerService;
//
//    /**
//     * 根据姓名查询推荐人是否存在
//     * @param request
//     * @param response
//     */
//    @RequestMapping("/getRef_name")
//    public void getRef_name(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String getRef_name = request.getParameter("getRef_name");
//        PrintWriter writer = response.getWriter();
//        List<Referrer> list =  referrerService.getRef_name(getRef_name);
//
//        if(null!=list&&!list.isEmpty()){
//            int ref_id = referrerService.selectByref_id(getRef_name);
//            response.getWriter().write(ref_id);
//        }else{
//            response.getWriter().write("false");
//        }
//    }
//
//    /**
//     * 根据编号查询推荐人的姓名
//     * @param refId
//     * @param request
//     * @param response
//     */
//    @RequestMapping("/getRef_Id")
//    public void getRef_Id(@RequestParam("refId")int refId, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String refName = referrerService.getRef_Id(refId);
//        if(null!=refName){
//            response.getWriter().write(refName);
//        }else{
//            response.getWriter().write("false");
//        }
//    }
//}
