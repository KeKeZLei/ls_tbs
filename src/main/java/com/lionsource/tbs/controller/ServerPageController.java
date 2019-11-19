package com.lionsource.tbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务端引导控制器
 *
 **/
@Controller
public class ServerPageController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }

}
