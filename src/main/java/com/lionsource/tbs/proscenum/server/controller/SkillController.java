package com.lionsource.tbs.proscenum.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.lionsource.tbs.comm.model.Skill;
import com.lionsource.tbs.comm.model.Tag;
import com.lionsource.tbs.proscenum.server.service.SkillService;
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
 * Date: Created in 2019/11/22 0022 下午 3:42
 * @Version 1.0
 */
@Controller
public class SkillController {
    @Autowired
    private SkillService skillService;

    /**
     * 查询所有的技能
     * @param response
     * @return
     */
    @RequestMapping("/skillAll")
    public void skillAll(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        List<Skill> list = skillService.selectAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("skillList", list);
        //输出到 ajax 对象中
        writer.write(jsonObject.toString());
    }
}
