package com.lionsource.tbs.proscenum.server.controller;

import com.lionsource.tbs.comm.model.City;
import com.lionsource.tbs.proscenum.server.service.CitySerivce;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 10:23
 * @Version 1.0
 */
@Controller
public class CityController {
    @Autowired
    private CitySerivce citySerivce;
    @RequestMapping("/getProCity")
    public void getProCity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int proId = Integer.parseInt(request.getParameter("proId"));
        //设置请求和响应编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //输出流
        PrintWriter writer = response.getWriter();
        //字符串 进行等值比较  字符串放前面
        //直接把此对象加入到 json中
        JSONObject jsonObject =new JSONObject();
        //调用 dao中根据 省份id 查询 城市的
        List<City> list = citySerivce.getAllCity(proId);
        System.out.println("城市:"+list);
        jsonObject.put("cityList",list);
        writer.write(jsonObject.toString());
    }
}
