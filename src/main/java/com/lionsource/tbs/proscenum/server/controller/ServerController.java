package com.lionsource.tbs.proscenum.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.lionsource.tbs.comm.model.*;
import com.lionsource.tbs.comm.utils.sendsms;
import com.lionsource.tbs.proscenum.server.msg.RandomValidateCodeUtil;
import com.lionsource.tbs.proscenum.server.service.*;
import com.lionsource.tbs.proscenum.serverD.service.EvaluateServices;
import com.lionsource.tbs.proscenum.serverY.service.StewardyServiceI;
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
import java.text.DateFormat;
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
    @Autowired
    StewardyServiceI serviceI;

    //评价yc
    @Autowired
    private EvaluateServices evaluateServices;


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
                request.setAttribute("steName", memname);
                int memid=0;
                for (Member ls:stewardList
                ) {
                    memid=ls.getMemId();
                }
                System.err.println("memid:"+memid);

                //根据评价用户编号查询用户信息
                List<Evaluate> memberLists=evaluateServices.getByMemid(memid);
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
                for(int i=0;i<memberLists.size();i++){
                    Date a= memberLists.get(i).getEvaCreatetime();
                    Date b=memberLists.get(i).getEvaTime();
                    memberLists.get(i).setEvaCreatetimes( df.format(a));
                    memberLists.get(i).setEvaTimes(df.format(b));
                }
                session.setAttribute("memberLists",memberLists);
                System.err.println(memberLists);
                int ids=0;
                int steid=0;
                int evaid=0;
                for (Evaluate ls:memberLists
                ) {
                    ids=ls.getSteId();
                    steid=ls.getSteId();
                    evaid=ls.getEvaId();
                }
                session.setAttribute("steid",steid);
                session.setAttribute("evaid",evaid);
                //根据评价用户编号查询用户信息
                List<Evaluate> memberList=evaluateServices.getByMemid(memid);
                session.setAttribute("memberLists",memberList);
                //根据评价管家编号查询用户信息
                List<Steward> stewardLists=evaluateServices.getBySteids(memid);
                session.setAttribute("stewardLists",stewardLists);

                List<Steward> lists = serviceI.selectAll();
                session.setAttribute("list",lists);
                session.setAttribute("memId",stewardList.get(0).getMemId());
                return "redirect:../tests";
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
    @RequestMapping("/getEvalyateAdd")
    public String  getEvalyateAdd(@RequestParam("evaid")int evaid,@RequestParam("memid")int memid,@RequestParam("steid")int steid,@RequestParam("evaComment")String evaComment,@RequestParam("evaAgreestate")int evaAgreestate,@RequestParam("evaProquality") int evaProquality,@RequestParam("evaSkill") int evaSkill,@RequestParam("evaService") int evaService){
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = df.format(date);
        //添加
        Evaluate evaluate=new Evaluate(evaid,memid,steid,evaService,evaSkill,evaProquality,evaComment,evaAgreestate,1,time,time,1);
        int count =evaluateServices.getEvaluateAdd(evaluate);

        return "serverZ/guanjiapingjia";
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
                int memid=0;
                for (Member ls:memberList
                ) {
                    memid=ls.getMemId();
                }

                session.setAttribute("memid",memid);
                System.err.println("memid:"+memid);
                //根据评价用户编号查询用户信息
                List<Evaluate> memberLists=evaluateServices.getByMemid(memid);
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
                for(int i=0;i<memberLists.size();i++){
                    Date a= memberLists.get(i).getEvaCreatetime();
                    Date b=memberLists.get(i).getEvaTime();
                    memberLists.get(i).setEvaCreatetimes( df.format(a));
                    memberLists.get(i).setEvaTimes(df.format(b));
                }
                session.setAttribute("memberLists",memberLists);
                System.err.println(memberLists);
                int ids=0;
                int steid=0;
                int evaid=0;
                for (Evaluate ls:memberLists
                ) {
                    ids=ls.getSteId();
                    steid=ls.getSteId();
                    evaid=ls.getEvaId();
                }
                session.setAttribute("steid",steid);
                session.setAttribute("evaid",evaid);
                //根据评价管家编号查询用户信息
                List<Steward> stewardLists=evaluateServices.getBySteids(ids);
                System.err.println("评价管家"+stewardLists);
                session.setAttribute("stewardLists",stewardLists);

                request.setAttribute("tisiLogin","登录成功");
                request.setAttribute("ste_name",ste_name);
                List<Steward> lists = serviceI.selectAll();
                session.setAttribute("list",lists);
                session.setAttribute("memId",memberList.get(0).getMemId());
                System.out.println("----------========="+memberList.get(0).getMemId());
                return "redirect:../tests";
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
                //查询推荐用户数
                int membercount=  referrerService.getMemberCount(id);
                session.setAttribute("membercount",membercount);
//                System.out.println(count);
                //查询推荐实名用户数
                int membercounts= referrerService.getMemberCountsm(id);
                session.setAttribute("membercounts",membercounts);
//                System.out.println(counts);
                //查询推荐管家数
                int stewardcount=  referrerService.getStewardCount(id);
                session.setAttribute("stewardcount",stewardcount);
                //查询推荐实名管家数
                int stewardcounts= referrerService.getStewardCountsm(id);
                session.setAttribute("stewardcounts",stewardcounts);
                //根据ref_id查询推荐用户信息
                List<Member> MemberList=referrerService.getMemberList(id);
                session.setAttribute("MemberList",MemberList);
                //根据ref_id查询推荐实名用户信息
                List<Member> MembersmList= referrerService.getMembersmList(id);
                session.setAttribute("MembersmList",MembersmList);
                //根据ref_id查询推荐管家信息
                List<Steward> StewardList= referrerService.getStewardList(id);
                session.setAttribute("StewardList",StewardList);
                List<Steward> StewardListsm=referrerService.getStewardsmList(id);
                session.setAttribute("StewardListsm",StewardListsm);
                System.err.println(StewardList);
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
                session.setAttribute("ste_tel",ste_tel);
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
     * 根据姓名查询个人信息到我的名片
     */
    @RequestMapping("/getSelectAllz")
    public String getSelectAllz(Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String steName = (String) session.getAttribute("ste_name");
        String steTel =(String) session.getAttribute("ste_tel");
        Steward allSteName = stewardService.getSelectAllSteName(steName,steTel);
        System.out.println("查询结果:"+allSteName);
        model.addAttribute("allSteName",allSteName);
        return "serverZ/callingCard";
    }
    /**
     * 根据姓名查询个人信息到我的名片
     */
    @RequestMapping("/updatePersonage")
    public String updatePersonage(Model model,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String steName = (String) session.getAttribute("ste_name");
        String steTel =(String) session.getAttribute("ste_tel");
        Steward allSteName = stewardService.getSelectAllSteName(steName,steTel);
        System.out.println("查询结果:"+allSteName);
        model.addAttribute("allSteName",allSteName);
        return "serverZ/updatePersonage";
    }
    /**
     * 根据服务人员姓名查询个人信息
     * @param
     * @return
     */
    @RequestMapping("/getSelectAllSteName")
    public String getSelectAllSteName(Model model, HttpSession session, HttpServletRequest request){
        String ste_name = (String) session.getAttribute("ste_name");
        String ste_tel = (String) session.getAttribute("ste_tel");
        System.out.println("姓名:"+ste_name);
        Steward steward = stewardService.getSelectAllSteName(ste_name,ste_tel);
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
     * 根据姓名和手机号修改管家信息
     * @param steName
     * @param steTel
     * @param steWorkform
     * @param steWorkstate
     * @param steTag
     * @param money
     * @param steDescribe
     * @param ste_province
     * @param serverCity
     * @return
     */
    @RequestMapping("/updateByNameTel")
    public String updateByNameTel(HttpServletRequest request,@RequestParam("steName")String steName,@RequestParam("steTel")String steTel,@RequestParam("steWorkstate")String steWorkstate,
                                  @RequestParam("steTag")String steTag,@RequestParam("money")int money,@RequestParam("steDescribe")String steDescribe,
                                  @RequestParam("serverProvince")int ste_province,@RequestParam("serverCity") int serverCity,@RequestParam("steWorkform")String steWorkform){
        Steward steward = new Steward();
        steward.setSteName(steName);
        steward.setSteTel(steTel);
        steward.setSteTag(steTag);
        steward.setSteProvince(ste_province);
        steward.setSteCity(serverCity);
        steward.setSteExpsalary(money);
        steward.setSteDescribe(steDescribe);
        steward.setSteWorkform(steWorkform);
        steward.setSteWorkstate(steWorkstate);
        int result = stewardService.updateByNameTel(steward);
        if(result>0){
            request.setAttribute("show","修改成功");
            return "serverZ/callingCard";
        }else{
            request.setAttribute("show","修改失败");
            return "serverZ/updatePersonage";
        }
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

