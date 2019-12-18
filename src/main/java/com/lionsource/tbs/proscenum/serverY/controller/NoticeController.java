package com.lionsource.tbs.proscenum.serverY.controller;

import com.lionsource.tbs.comm.model.*;
import com.lionsource.tbs.proscenum.server.service.EvaluateService;
import com.lionsource.tbs.proscenum.server.service.StewardtypeService;
import com.lionsource.tbs.proscenum.serverY.service.*;
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
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 通知操作控制器
 */
@Controller
public class NoticeController {

    @Autowired
    private StewardyServiceI serviceI;
    @Autowired
    private EvaluateServicel evaluateServicel;
    @Autowired
    private CertificateServicel certificateServicel;
    @Autowired
    private NoticeServicel noticeServicel;
    @Autowired
    private InterviewServicel interviewServicel;


    /**
     * 获取会员编号和管家编号
     * 根据管家编号显示管家的详细信息和评分
     * @return
     */
    @RequestMapping("getId")
    public String getid(Model model, String memId, String steId){
        System.out.println("会员编号："+memId);
        System.out.println("管家编号："+steId);
        //管家信息
        Steward steward = serviceI.selectByPrimaryKey(Integer.parseInt(steId));
        //管家评分
        List<Evaluate> evaluates = evaluateServicel.selectEvaluate(Integer.parseInt(steId));
        //管家证书
        List<Certificate> list = certificateServicel.selectsteid(Integer.parseInt(steId));

        model.addAttribute("steward",steward);

        model.addAttribute("list",list);
        //计算 服务态度，专业技能和职业素养平均值
        int fwtds=0;
        int zyjns=0;
        int zysys=0;
        if(evaluates.size()>0){
            for (int i=0;i<evaluates.size();i++){
                int fwtd =evaluates.get(i).getEvaService();
                int zyjn =evaluates.get(i).getEvaSkill();
                int zysy =evaluates.get(i).getEvaProquality();
                fwtds=fwtd+fwtds;
                zyjns=zyjn+zyjns;
                zysys=zysy+zysys;
            }
            fwtds=fwtds/evaluates.size();
            zyjns=zyjns/evaluates.size();
            zysys=zysys/evaluates.size();
            System.out.println(fwtds);
            System.out.println(zyjns);
            System.out.println(zysys);
            model.addAttribute("pjcs",evaluates.size());
            model.addAttribute("fwtds",fwtds);
            model.addAttribute("zyjns",zyjns);
            model.addAttribute("zysys",zysys);
        }

        System.out.println(evaluates);
        System.out.println(steward);
        System.out.println(list);

        return "serverZ/yit/gjxx";
    }

    /**
     * 添加面试通知
     * @return
     */
    @RequestMapping("tjmstz")
    public void tjmstz(HttpServletResponse response, String memId, String steId) throws IOException {

        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println("会员编号："+memId);
        System.out.println("管家编号："+steId);

        PrintWriter out = response.getWriter();
        Notice notice=new Notice();
        notice.setMemId(Integer.parseInt(memId));
        notice.setSteId(Integer.parseInt(steId));
        notice.setNotTitle("面试");
        notice.setNotType("面试通知");
        notice.setNotCreatetime((java.sql.Date)new Date());
        notice.setNotContent("你符合我的需求，希望你成为我的管家");
        int insert = noticeServicel.insert(notice);
        if(insert>0){
            out.print("预约成功！请查看通知！");
        }else {
            out.print("预约失败！请重试!");
        }
        out.flush();
        out.close();
    }

    /**
     * 显示所有面试消息
     * @return
     */
    @RequestMapping("msxx")
    public String selectmsxx(Model model,String memId){
        System.out.println("会员编号："+memId);
        List<Interview> listi = interviewServicel.selectmemId(Integer.parseInt(memId));
        System.out.println(listi);
        model.addAttribute("listi",listi);
        return "serverZ/yit/msxx";
    }

    /**
     * 显示所有消息信息
     * @return
     */
    @RequestMapping("xxxx")
    public String selectxxxx(Model model,String memId){
        System.out.println("会员编号:"+memId);
        List<Notice> list = noticeServicel.selectmemId(Integer.parseInt(memId));
        model.addAttribute("list",list);
        System.out.println(list);
        return "serverZ/yit/xxxx";
    }
}
