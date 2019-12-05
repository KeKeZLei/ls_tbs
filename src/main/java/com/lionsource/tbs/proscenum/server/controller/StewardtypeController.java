package com.lionsource.tbs.proscenum.server.controller;

import com.lionsource.tbs.proscenum.server.service.StewardtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/12/4 0004 下午 4:28
 * @Version 1.0
 * 管家类型操作类
 */
@Controller
public class StewardtypeController {
    @Autowired
    private StewardtypeService stewardtypeService;

    /**
     * 根据工作类型编号查询类型名称
     * @param wTypeId
     */
    @RequestMapping("/sTypeName")
    public void sTypeName(@RequestParam("wTypeId") int wTypeId, HttpServletResponse response) throws IOException {
        String wardTypeName = stewardtypeService.selectWardType(wTypeId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        response.getWriter().write(wardTypeName);
    }
}
