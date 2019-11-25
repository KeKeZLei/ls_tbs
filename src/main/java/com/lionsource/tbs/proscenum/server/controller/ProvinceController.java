package com.lionsource.tbs.proscenum.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.lionsource.tbs.comm.model.City;
import com.lionsource.tbs.comm.model.Province;
import com.lionsource.tbs.proscenum.server.service.CitySerivce;
import com.lionsource.tbs.proscenum.server.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 9:47
 * @Version 1.0
 * 省份
 */
@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CitySerivce citySerivce;

    /**
     * 省份和城市二级联动
     */
    @RequestMapping("/getProvinceCity")
    public void getProvinceCity (HttpServletResponse response,HttpServletRequest request) throws Exception {
        //设置请求和响应编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //输出流
        PrintWriter writer = response.getWriter();
        //字符串 进行等值比较  字符串放前面
        //直接把此对象加入到 json中
        JSONObject jsonObject =new JSONObject();
        //查询所有的省份信息
        List<Province> list =  provinceService.selectAll();
        jsonObject.put("provinList",list);
        //输出到 ajax 对象中
        writer.write(jsonObject.toString());
    }
}