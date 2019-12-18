package com.lionsource.tbs.proscenum.serverY.controller;

import com.lionsource.tbs.comm.dao.MemberMapper;
import com.lionsource.tbs.comm.model.Memaddress;
import com.lionsource.tbs.comm.model.Member;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.comm.utils.sendsms;
import com.lionsource.tbs.proscenum.server.service.MemberService;
import com.lionsource.tbs.proscenum.serverY.service.MemaddressMapperYI;
import com.lionsource.tbs.proscenum.serverY.service.MemberyServerI;
import com.lionsource.tbs.proscenum.serverY.service.StewardyServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
public class StewardController {

    @Autowired
    private StewardyServiceI serviceI;
    @Autowired
    private MemberyServerI memberyServerI;
    @Autowired
    private MemaddressMapperYI mapperYI;

    private String pdyzm="111111";

    /**
     * 定制管家
     * @return
     */
    @RequestMapping("/dzgj")
    public void dzgj(HttpServletRequest request, Model model, HttpServletResponse response, String ste_worktype, String ste_workform, String ste_contracttype, String ste_workyear, String ste_expsalary, String ste_native, String ste_tag, String mem_name, String mem_tel, String yzm) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        //拼接职位类别：模糊查询
        ste_worktype="%"+ste_worktype+"%";
        //判断是否住家
        if(ste_workform.equals("不住家")){
            ste_workform=null;
        }
        //判断工作年限是否大于3年
        int ste_workyears=Integer.parseInt(ste_workyear);
        if (ste_workyears==4){
            ste_workyears=0;
        }
        //期望工资 转数据类型
        int ste_expsalarys=Integer.parseInt(ste_expsalary);
        //判断籍贯是否为空
        if(ste_native.equals("")){
            ste_native=null;
        }
        //个人标签
        //拼接职位类别：模糊查询
        //判断个人标签是否为空
        if (ste_tag.equals("")){
            ste_tag=null;
        }else {
            ste_tag="%"+ste_tag+"%";
        }
        Member member=new Member();
        member.setMemName(mem_name);                //姓名
        member.setMemTel(mem_tel);                  //手机号码
        member.setMemCall(mem_name);                //称呼
        member.setMemStewardtype(ste_worktype);     //管家类型
        member.setMemWorkform(ste_workform);        //管家工作形式
        member.setMemContracttype(Integer.parseInt(ste_contracttype));//管家签约形式
        member.setMemWorkyear(ste_workyears);       //管家工作年限
        member.setMemNativedemand(ste_native);      //籍贯要求
        member.setMemSkilldemand(ste_tag);           //技能要求
        member.setMemExpectpay(Integer.parseInt(ste_expsalary));//预计薪资
        member.setMemCreatetime(new Date());        //注册时间
        System.out.println("当前系统时间："+new Date());
        System.out.println("已发送的验证码:"+pdyzm);
        System.out.println("职位类别："+ste_worktype);
        System.out.println("是否住家："+ste_workform);
        System.out.println("管家签约形式(1=中介制,2=雇佣制)："+ste_contracttype);
        System.out.println("工作年限:"+ste_workyear);
        System.out.println("期望工资:"+ste_expsalary);
        System.out.println("籍贯:"+ste_native);
        System.out.println("个人标签："+ste_tag);
        System.out.println("用户名："+mem_name);
        System.out.println("电话号码："+mem_tel);
        System.out.println("验证码："+yzm);
        //管家工作形式
        //判断手机号码是否重复
        List<Member> allMemnameTel = memberyServerI.getAllMemnameTel(mem_tel);
        if(allMemnameTel.size()>0){//手机号码存在
            out.print("手机号码已存在，是否登录!");
            System.out.println("手机号码已存在，是否登录!");
        }else

        if(!pdyzm.equals(yzm)) {
            out.print("输入的验证码不一至，请重新输入！");
        }else{
            //调用添加方法
            if(memberyServerI.insert(member)>0){
                //调用查询方法方法
                List<Steward> list = serviceI.selectAllfbxp(ste_worktype,ste_workform,ste_contracttype,ste_workyears,ste_expsalarys,ste_native,ste_tag);
                System.out.println(list);
                HttpSession session = request.getSession();
                System.out.println("管家-----");
                session.setAttribute("list",list);
                System.out.println("根据手机号码查询会员编号!");
                //根据手机号码查询会员编号
                List<Member> allMemnameTels = memberyServerI.getAllMemnameTel(mem_tel);
                Integer memId = allMemnameTels.get(0).getMemId();
                System.out.println("会员编号-------------------------------------："+memId);
                session.setAttribute("memId",memId);
                out.print("定制成功！");
            }else{
                out.print("定制失败！");
            }
        }

    }

    /**
     * 判断手机号码是否存在
     */
    @RequestMapping("/sjhmyz")
    public void sjhmyz(HttpServletResponse response, String mem_tel) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        List<Member> allMemnameTel = memberyServerI.getAllMemnameTel(mem_tel);
        if(allMemnameTel.size()>0){//手机号码存在
            out.print("手机号码已存在，是否登录!");
            System.out.println("手机号码已存在，是否登录!");
        }else {
            out.print("zq");
        }
    }

    /**
     * 发送验证码
     */
    @RequestMapping("/fsyzm")
    public void fsyzm(HttpServletResponse response,String mem_tel) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
//        sendsms sendsms=new sendsms();
//        pdyzm=sendsms.duanxin(mem_tel);
        out.print("验证码发送成功!");
    }

    /**
     * 类型
     * 预约管家
     */
    @RequestMapping("/lx")
    public void lx(HttpServletResponse response,HttpServletRequest request,String ste_contracttype,String ste_worktype) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("-----------------------------------进入类型");
        //拼接职位类别：模糊查询
        ste_worktype="%"+ste_worktype+"%";
        System.out.println("管家签约形式(1=中介制,2=雇佣制)："+ste_contracttype);
        System.out.println("职位类别："+ste_worktype);
        Integer ste_contracttypes=Integer.parseInt(ste_contracttype);
        List<Steward> list = serviceI.selectAlllx(ste_contracttypes, ste_worktype);
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        for (Steward i:list
             ) {
            System.out.println(i);
        }
        out.print("选择成功！");

        out.flush();
        out.close();
    }

    /**
     * 经验
     * 预约管家
     */
    @RequestMapping("/jy")
    public void lx(HttpServletResponse response,HttpServletRequest request,String ste_workyear) throws IOException {
        System.out.println("-----------------------------------进入经验");
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("工作年限:"+ste_workyear);
        PrintWriter out = response.getWriter();
        Integer ste_workyears=Integer.parseInt(ste_workyear);
        if(ste_workyears==4){
            ste_workyears=0;
        }
        List<Steward> stewards = serviceI.selectAlljy(ste_workyears);
        HttpSession session=request.getSession();
        session.setAttribute("list",stewards);
        out.print("选择成功！");
        out.flush();
        out.close();
    }

    /**
     * 更多
     * 预约管家
     */
    @RequestMapping("/gd")
    public void gd(HttpServletResponse response,HttpServletRequest request,String ste_workform,String ste_age,String ste_native,String ste_tag) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("-----------------------------------进入更多");
        String ste_tags="%"+ste_tag+"%";
        String ste_natives="%"+ste_native+"%";
        System.out.println("工作形式:"+ste_workform);
        System.out.println("年龄:"+ste_age);
        System.out.println("籍贯:"+ste_natives);
        System.out.println("个人标签："+ste_tags);
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        List<Steward> l = serviceI.selectAllgd  (ste_workform, ste_age, ste_natives, ste_tags);
        session.setAttribute("list",l);
        out.print("选择成功！");
        out.flush();
        out.close();
    }

    /**
     * 我的地址
     * @return
     */
    @RequestMapping("/dizhi")
    public String dizhi(Model model){
        List<Memaddress> list = mapperYI.selectAll();
        model.addAttribute("list",list);
        for (Memaddress i:list
             ) {
            System.out.println(i);
        }
        return "serverZ/yit/dizhi";
    }

    /**
     *删除地址
     * @return
     */
    @RequestMapping("/deleteBy")
    public String deleteByPrimaryKey(String maId){
        Integer maIds=Integer.parseInt(maId);
        System.out.println("---------------------------"+maIds);
        mapperYI.deleteByPrimaryKey(maIds);
        return "redirect:dizhi";
    }

    /**
     * 修改地址
     * @return
     */
    @RequestMapping("/updateBys")
    public void updateByPrimaryKey(HttpServletResponse response,String meId,String maContact,String maTel,String maAddress) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("编号："+meId);
        System.out.println("联系人姓名："+maContact);
        System.out.println("电话："+maTel);
        System.out.println("详细地址："+maAddress);

        Memaddress memaddress=new Memaddress();
        memaddress.setMaId(Integer.parseInt(meId));
        memaddress.setMaContact(maContact);
        memaddress.setMaTel(maTel);
        memaddress.setMaAddress(maAddress);

        int insert = mapperYI.updateByPrimaryKey(memaddress);
        if(insert>0){
            out.print("修改成功!");
        }else {
            out.print("修改失败!");
        }
        out.flush();
        out.close();
    }

    /**
     * 新增地址
     * @return
     */
    @RequestMapping("/addMs")
    public void insert(HttpServletResponse response,String maContact,String maTel,String maAddress) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        System.out.println("联系人姓名："+maContact);
        System.out.println("电话："+maTel);
        System.out.println("详细地址："+maAddress);

        Memaddress memaddress=new Memaddress();
        memaddress.setMaContact(maContact);
        memaddress.setMaTel(maTel);
        memaddress.setMaAddress(maAddress);

        int insert = mapperYI.insert(memaddress);
        if(insert>0){
            out.print("添加成功!");
        }else {
            out.print("添加失败!");
        }

        out.flush();
        out.close();
    }

}

