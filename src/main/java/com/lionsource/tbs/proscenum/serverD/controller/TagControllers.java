package com.lionsource.tbs.proscenum.serverD.controller;

import com.lionsource.tbs.proscenum.serverD.service.TagServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TagController
 * yc
 */
@Controller
public class TagControllers {
        @Autowired
        private TagServiceI tagServiceI;

        @RequestMapping("/TagNames")
        public void sTypeName(@RequestParam("steIds") int steId, HttpServletResponse response, HttpServletRequest request, HttpSession session) throws IOException {
            String steNames = tagServiceI.selectTagName(steId);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            System.err.println(steNames);
            response.getWriter().write(steNames);
//            session.setAttribute("steNames",steNames);
//            return "../../../serverZ/guanjialiebiao";
        }
}
