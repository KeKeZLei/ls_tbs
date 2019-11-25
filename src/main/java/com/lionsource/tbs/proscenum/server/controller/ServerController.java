package com.lionsource.tbs.proscenum.server.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.comm.model.Stewardtype;
import com.lionsource.tbs.proscenum.server.msg.MobileMessageSend;
import com.lionsource.tbs.proscenum.server.response.CommonRetuenType;
import com.lionsource.tbs.proscenum.server.service.StewardService;
import com.lionsource.tbs.proscenum.server.service.StewardtypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/20 0020 下午 2:38
 * @Version 1.0
 * 服务端控制器
 */
@Controller
public class ServerController {
    @Autowired
    StewardtypeService stewardtypeService;
    @Autowired
    StewardService stewardService;
    /**
     * 打开从业者申请表
     * @param request
     * @return
     */
    @RequestMapping("/apply")
    public String apply(HttpServletRequest request) {
        return "serverZ/apply";
    }

    @RequestMapping("/homePage")
    public String homePage(HttpServletRequest request){
        return "serverZ/homePage";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        return "serverZ/register";
    }
    @RequestMapping("/register1")
    public String register1(HttpServletRequest request){
        return "serverZ/register1";
    }
    @RequestMapping("/server/login")
    public String login(HttpServletRequest request){
        return "serverZ/login";
    }
    /**
     * 查询所有的管家的类型
     * @param response
     * @return
     */
    @RequestMapping("/stewardtype")
    public void stewardMapperType(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        List<Stewardtype> list = stewardtypeService.selectAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stewardtypeList", list);
        //输出到 ajax 对象中
        System.out.println(jsonObject.toString());
        writer.write(jsonObject.toString());
    }
    @RequestMapping("/serverAddApply")
    public String serverAddApply(Model model, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String ste_name = request.getParameter("ste_name");
        String ste_worktype = request.getParameter("ste_worktype");
        String ste_tel = request.getParameter("ste_tel");
        int ste_age = Integer.parseInt(request.getParameter("ste_age"));
        int ste_workyear = Integer.parseInt(request.getParameter("ste_workyear"));
        String ste_native = request.getParameter("ste_native");
        int ste_sex = Integer.parseInt(request.getParameter("ste_sex"));
        String ste_describe = request.getParameter("ste_describe");
        String ste_address = request.getParameter("ste_address");
        String ste_tag = request.getParameter("ste_tag");
        int money = Integer.parseInt(request.getParameter("money"));
        int ste_province = Integer.parseInt(request.getParameter("ste_province"));
        int ste_city = Integer.parseInt(request.getParameter("ste_city"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date steCreatetime = null;
        steCreatetime=df.parse(df.format(new Date()));
        Steward steward;
        //验证验证码是否和手机上收到的一样
        String sessionOtpCode = (String) request.getSession().getAttribute(ste_tel);//不能使用toStrng()转换，不然会空指针异常
        if (!StringUtils.equals(sessionOtpCode, ste_tel)) {
            model.addAttribute("tisi", "注册失败，验证码错误！");
            return "/register";
        } else if(request.getParameter("ref_id")==""){
             steward=new Steward(0, null,null ,null,null,ste_name,ste_tel,null,
                    null,null,null,ste_sex,ste_age,ste_native,ste_address,
                    null,null,null,ste_workyear,money,null,
                    null, steCreatetime, 0,ste_province,
                    ste_city, null,ste_worktype,null,ste_tag,ste_describe);
        }else{
           int ref_id = Integer.parseInt(request.getParameter("ref_id"));
             steward=new Steward(0, ref_id,null ,null,null,ste_name,ste_tel,null,
                    null,null,null,ste_sex,ste_age,ste_native,ste_address,
                    null,null,null,ste_workyear,money,null,
                    null, steCreatetime, 0,ste_province,
                    ste_city, null,ste_worktype,null,ste_tag,ste_describe);
        }

        int result = stewardService.serverAddApply(steward);
        if(result>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
            return "/register";
        }
        return "serverZ/register1.html";
    }

    //短信验证
    @RequestMapping("/getphone")
    @ResponseBody
    public CommonRetuenType getphone(String telphone,HttpServletRequest request) throws IOException {
        String otpCode= MobileMessageSend.sendMsg(telphone);
        request.getSession().setAttribute(telphone, otpCode);
        System.out.println("电话:" + telphone + "验证码:" + otpCode);
        return CommonRetuenType.create(null);
    }
}
