package com.lionsource.tbs.proscenum.server.controller;

import com.lionsource.tbs.comm.model.City;
import com.lionsource.tbs.comm.model.County;
import com.lionsource.tbs.proscenum.server.service.CountyService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/2 0002 上午 9:16
 * @Version 1.0
 * 区县操作
 */
@Controller
public class CountyController {
    @Autowired
    CountyService countyService;

    /**
     * 根据城市的编号查询所有的区县
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getCityCounty")
    public void getCityCounty(@RequestParam("cityid") int cityid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置请求和响应编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //输出流
        PrintWriter writer = response.getWriter();
        //字符串 进行等值比较  字符串放前面
        //直接把此对象加入到 json中
        JSONObject jsonObject =new JSONObject();
        //调用 dao中根据 省份id 查询 城市的
        List<County> list = countyService.getAllCounty(cityid);
        jsonObject.put("CountList",list);
        writer.write(jsonObject.toString());
    }
}
