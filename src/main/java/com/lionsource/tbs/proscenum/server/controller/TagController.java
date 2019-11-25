package com.lionsource.tbs.proscenum.server.controller;


import com.alibaba.fastjson.JSONObject;
import com.lionsource.tbs.comm.model.Stewardtype;
import com.lionsource.tbs.comm.model.Tag;
import com.lionsource.tbs.proscenum.server.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 4:46
 * @Version 1.0
 * 个人标签
 */
@Controller
public class TagController {
    @Autowired
    private TagService tagService;
    /**
     * 查询所有的个人标签
     * @param response
     * @return
     */
    @RequestMapping("/tagAll")
    public void tagAll(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        List<Tag> list = tagService.selectAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagList", list);
        //输出到 ajax 对象中
        System.out.println(jsonObject.toString());
        writer.write(jsonObject.toString());
    }
}
