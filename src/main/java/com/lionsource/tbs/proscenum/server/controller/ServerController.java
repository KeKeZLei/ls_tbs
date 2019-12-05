package com.lionsource.tbs.proscenum.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.lionsource.tbs.comm.model.*;
import com.lionsource.tbs.comm.utils.sendsms;
import com.lionsource.tbs.proscenum.server.msg.RandomValidateCodeUtil;
import com.lionsource.tbs.proscenum.server.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
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
    //管家类型
    @Autowired
    StewardtypeService stewardtypeService;
    //管家
    @Autowired
    StewardService stewardService;
    //推荐人
    @Autowired
    ReferrerService referrerService;
    //用户
    @Autowired
    MemberService memberService;
    //评论
    @Autowired
    EvaluateService evaluateService;
    //雇佣关系
    @Autowired
    EmprelationService emprelationService;



//    @RequestMapping("/tuijianrenduan")
//    public String tuijianrenduan(HttpServletRequest request) {
//        return "serverZ/tuijianrenduan";
//    }
//
//    @RequestMapping("/yonghu")
//    public String yonghu(HttpServletRequest request) {
//            return "serverZ/yonghu";
//        }


    /**
     * 打开从业者申请表
     * @param request
     * @return
     */
    @RequestMapping("/apply")
    public String apply(HttpServletRequest request) {
        return "serverZ/apply";
    }

    /**
     * 打开官方首页
     * @param request
     * @return
     */
    @RequestMapping("/homePage")
    public String homePage(HttpServletRequest request){
        return "serverZ/homePage";
    }

    /**
     * 服务人员注册页面
     * @param request
     * @return
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        return "serverZ/register";
    }
    @RequestMapping("/register1")
    public String register1(HttpServletRequest request){
        return "serverZ/register1";
    }

    /**
     * 用户名和手机号码登录页面
     * @param request
     * @return
     */
    @RequestMapping("/server/login")
    public String login(HttpServletRequest request){
        return "serverZ/login";
    }

    /**
     * 手机号码短信验证登录页面
     * @param request
     * @return
     */
    @RequestMapping("/server/login1")
    public String login1(HttpServletRequest request){
        return "serverZ/login1";
    }

    /**
     * 服务人员个人主页
     * @param request
     * @return
     */
    @RequestMapping("/personalHomepage")
    public String personalHomepage(HttpServletRequest request){
        return "serverZ/personalHomepage";
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
        writer.write(jsonObject.toString());
    }
    //获取验证码
    @RequestMapping("/getimage")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = RandomValidateCodeUtil.createImage();
        //将验证码存入Session
        session.setAttribute("imageCode", objs[0]);
        request.getSession().setAttribute("codeTime",new Date().getTime());
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

    /**
     * 判断图片验证码是否跟输入的一样
     * @param yzCode
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/serverImages")
    public void serverImages(@RequestParam("yzCode") String yzCode,HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取存储的验证码
        //获取存储的验证码
        String yzCodes = (String) request.getSession().getAttribute("imageCode");
        //判断验证码是否正确
        if(!(yzCode).equalsIgnoreCase(yzCodes)||yzCode==null||StringUtils.isEmpty(yzCode)) {
            response.getWriter().write("false");
        }else{
            response.getWriter().write("true");
        }
    }

    /**
     * 根据手机和验证码登录
     * @param ste_tel
     * @param yzm
     * @param phcode
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/server/mobilePhone")
    public String mobilePhone(@RequestParam("type") String type,@RequestParam("ste_tel")String ste_tel,@RequestParam("yzm") String yzm,
                              @RequestParam("phcode")String phcode,HttpSession session,HttpServletRequest request,HttpServletResponse response){
        //判断用户是怎么进行登录的
        if(type.equals("用户登录")){
            Member member = new Member();
            member.setMemTel(ste_tel);
            List<Member> stewardList = memberService.getMemtel(member);
            if(stewardList!=null) {
                String memname = memberService.getMemname(member);
                request.setAttribute("ste_name", memname);
                return "serverZ/personalHomepage";
            }else {
                request.setAttribute("tisi", "登录失败");
                return "serverZ/login";
            }
        }if(type.equals("推荐人登录")){
            Referrer referrer = new Referrer();
            referrer.setRefTel(ste_tel);
            List<Referrer> refnameReftel = referrerService.getRefnameReftel(referrer);
            if(refnameReftel!=null){
                String referrerRefname = referrerService.getReferrerRefname(referrer);
                request.setAttribute("ste_name",referrerRefname);
                 String ste_tels= ste_tel;
                //根据id查询用户相关信息
                List<Referrer> list=  referrerService.getReferrers(ste_tels);

                int id=0;
                for (Referrer ls:list) {
                    id=ls.getRefId();
                }
                //查询推荐管家数
                int count=  referrerService.getMemberCount(id);
                request.setAttribute("count",count);

                request.setAttribute("referrers",list);
                return "serverZ/tuijianrenduan";
            }else {
                request.setAttribute("tisi","登录失败");
                return "serverZ/login";
            }
        }else if(type.equals("服务人员登录")){
            //验证验证码是否和手机上收到的一样
            if(!yzm.equals(phcode)){
                System.out.println("验证码错误");
                request.setAttribute("tisi","验证码错误");
                return "serverZ/login1";
            }else{
                Steward steward = new Steward();
                steward.setSteTel(ste_tel);
                List<Steward> stetel = stewardService.getStetel(steward);
                if(stetel!=null){
                    String ste_name = stewardService.getStetelSteName(steward);
                    session.setAttribute("tisi","登录成功");
                    session.setAttribute("ste_name",ste_name);
                    return "redirect:../getSelectAllSteName";
                }else{
                    request.setAttribute("tisi","登录失败");
                    return "serverZ/login";
                }
            }
        }
        return "serverZ/login";
    }
    /**
     *通过用户名和手机号进行登录
     * @return
     */
    @RequestMapping("/server/serverLogin")
    public String serverLogin(HttpSession session,@RequestParam("type") String type,@RequestParam("ste_name") String ste_name,@RequestParam("ste_tel") String ste_tel,@RequestParam("yzm") String yzm,HttpServletRequest request){
        //判断用户是怎么进行登录的
        if(type.equals("用户登录")){
            //用户登录
            Member member = new Member();
            member.setMemName(ste_name);
            member.setMemTel(ste_tel);
            List<Member> memberList = memberService.getMemnameTel(member);
            System.out.println("查询结果："+memberList);
            if(memberList==null||memberList.size()==0){
                System.out.println("登录失败");
                request.setAttribute("tisiLogin","登录失败");
                return "serverZ/login";
            }else{
                System.out.println("登录成功");
                request.setAttribute("tisiLogin","登录成功");
                request.setAttribute("ste_name",ste_name);
                return "serverZ/personalHomepage";
            }
        }else if(type.equals("推荐人登录")){
            //推荐人登录
            System.out.println("推荐人登录");
            Referrer referrer = new Referrer();
            referrer.setRefName(ste_name);
            referrer.setRefTel(ste_tel);
            List<Referrer> referrerList = referrerService.getRefnameReftel(referrer);
            if(referrerList==null||referrerList.size()==0){
                request.setAttribute("tisiLogin","登录失败");
                return "serverZ/login";
            }else{
                request.setAttribute("tisiLogin","登录成功");
                request.setAttribute("ste_name",ste_name);
                String ste_tels= ste_tel;
                //根据id查询用户相关信息
                List<Referrer> list=  referrerService.getReferrers(ste_tels);
//                System.out.println(list);
                int id=0;
                for (Referrer ls:list) {
                     id=ls.getRefId();
//                    System.out.println(id);
                }
                //查询推荐管家数
                int membercount=  referrerService.getMemberCount(id);
                request.setAttribute("membercount",membercount);
//                System.out.println(count);
                //查询推荐实名管家数
                int membercounts= referrerService.getMemberCountsm(id);
                request.setAttribute("membercounts",membercounts);
//                System.out.println(counts);
                //查询推荐用户数
                int stewardcount=  referrerService.getStewardCount(id);
                request.setAttribute("stewardcount",stewardcount);
                //查询推荐实名用户数
                int stewardcounts= referrerService.getStewardCountsm(id);
                request.setAttribute("stewardcounts",stewardcounts);
                //登录用户查询
                request.setAttribute("referrers",list);
                return "serverZ/tuijianrenduan";
            }
        }else if(type.equals("服务人员登录")){
            //服务人员登录
            System.out.println("服务人员登录");
            Steward steward = new Steward();
            steward.setSteName(ste_name);
            steward.setSteTel(ste_tel);
            List<Steward> stenameStetel = stewardService.getStenameStetel(steward);
            if(stenameStetel == null || stenameStetel.size() ==0 ){
                request.setAttribute("tisiLogin","登录失败");
                return "serverZ/login";
            }else{
                session.setAttribute("tisiLogin","登录成功");
                session.setAttribute("ste_name",ste_name);
                return "redirect:../getSelectAllSteName";
            }
        }
        return "serverZ/personalHomepage";
    }

    /**
     * 服务人员从业申请
     * @return
     * @throws ParseException
     */
    @RequestMapping("/serverAddApply")
    public String serverAddApply(@RequestParam("ste_name") String ste_name, @RequestParam("ste_worktype") String ste_worktype
            ,@RequestParam("yzm") String yzm, @RequestParam("ste_tel") String ste_tel, @RequestParam("ste_age") int ste_age, @RequestParam("ste_workyear") int ste_workyear
            , @RequestParam("ste_native") String ste_native, @RequestParam("ste_sex") int ste_sex, @RequestParam("ste_describe") String ste_describe,
                                 @RequestParam("ste_address") String ste_address, @RequestParam("ste_tag") String ste_tag, @RequestParam("money") int money,
                                 @RequestParam("ste_province") int ste_province, @RequestParam("ste_city") int ste_city, @RequestParam("phcode") String phcode, HttpSession session, HttpServletRequest request) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date steCreatetime = null;
        steCreatetime=df.parse(df.format(new Date()));

        Steward steward;
        //验证验证码是否和手机上收到的一样
        if (!yzm.equals(phcode)) {
            System.out.println("验证码错误");
            request.setAttribute("msg","验证码错误");
            return "serverZ/register";
        } else if(request.getParameter("ref_id")==""){
             steward=new Steward(0, null,null ,null,null,ste_name,ste_tel,null,
                    null,null,null,ste_sex,ste_age,ste_native,ste_address,
                    null,"未实名",1,ste_workyear,money,null,
                    "无", steCreatetime, 1,ste_province,
                    ste_city, null,ste_worktype,null,ste_tag,ste_describe);
        }else{
           int ref_id = Integer.parseInt(request.getParameter("ref_id"));
             steward=new Steward(0, ref_id,null ,null,null,ste_name,ste_tel,null,
                    null,null,null,ste_sex,ste_age,ste_native,ste_address,
                    null,"未实名",1,ste_workyear,money,null,
                    "无", steCreatetime, 1,ste_province,
                    ste_city, null,ste_worktype,null,ste_tag,ste_describe);
        }

        int result = stewardService.serverAddApply(steward);
        if(result>0){
            request.setAttribute("ste_name",ste_name);
        }else{
            request.setAttribute("msg","添加失败");
            return "serverZ/register";
        }
        return "serverZ/register1";
    }

    //短信验证
    @RequestMapping("/getphone")
    @ResponseBody
    public void getphone(@RequestParam("ste_tel") String ste_tel,HttpServletResponse response) throws IOException {
        try {
            //根据手机号码进行短信验证
            sendsms  sendsms = new sendsms();
            String show = sendsms.duanxin(ste_tel);
            System.out.println("验证码"+show);
            response.getWriter().write(show);
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().write("false");
        }
    }

    /**
     * 查询手机号码是否存在
     * @param request
     * @param response
     */
    @RequestMapping("/checkPhone")
    public void checkPhone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ste_tel = request.getParameter("ste_tel");
        PrintWriter writer = response.getWriter();
        int result =  stewardService.selectPhone(ste_tel);
        if(result>0){
            response.getWriter().write("false");
        }else{
            response.getWriter().write("true");
        }
    }

    /**
     * 根据服务人员姓名查询个人信息
     * @param
     * @return
     */
    @RequestMapping("/getSelectAllSteName")
    public String getSelectAllSteName(Model model, HttpSession session, HttpServletRequest request){
        String ste_name = (String) session.getAttribute("ste_name");
        System.out.println("姓名:"+ste_name);
        Steward steward = stewardService.getSelectAllSteName(ste_name);
        System.out.println("查询信息："+steward);
        if(steward!=null){
            int steId = stewardService.getSelectOneSteId(ste_name);
            //根据管家编号查询雇佣关系
            int empId = emprelationService.selectByEmpId(steId);
            int MepId;
            List<Member> memList = null;
            /**
             * 如果empId
             * 代表没有查询到雇佣关系
             * 在页面不用显示我的雇主
             */
            if(empId==0){
               MepId=0;
            }else{
                memList = memberService.selectAllByMemId(empId);
                System.out.println("memList"+memList);
                MepId=1;
            }
            request.setAttribute("EmpId",empId);
            model.addAttribute("memList",memList);
            model.addAttribute("steward",steward);
            return "serverZ/personalHomepage";
        }
        return "serverZ/personalHomepage";
    }
    /**
     * 服务人员退出系统
     * @throws IOException
     */
    @RequestMapping("/sessionInvalidate")
    public String sessionInvalidate(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("注销成功");
        request.setCharacterEncoding("utf-8");
        session = request.getSession();
        session.invalidate();
        return "serverZ/homePage";
    }

}
