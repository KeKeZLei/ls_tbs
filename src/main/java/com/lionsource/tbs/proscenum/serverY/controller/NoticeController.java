package com.lionsource.tbs.proscenum.serverY.controller;

import com.lionsource.tbs.comm.model.Certificate;
import com.lionsource.tbs.comm.model.Evaluate;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.server.service.EvaluateService;
import com.lionsource.tbs.proscenum.server.service.StewardtypeService;
import com.lionsource.tbs.proscenum.serverY.service.CertificateServicel;
import com.lionsource.tbs.proscenum.serverY.service.StewardyServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 通知操作控制器
 */
@Controller
public class NoticeController {

    @Autowired
    private StewardyServiceI serviceI;
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private CertificateServicel certificateServicel;


    /**
     * 获取会员编号和管家编号
     * 根据管家编号显示管家的详细信息和评分
     * @return
     */
    @RequestMapping("getId")
    public String getid(Model model,String memId, String steId){
        System.out.println("会员编号："+memId);
        System.out.println("管家编号："+steId);
        //根据管家编号显示管家的详细信息和评分
        //管家信息
        Steward steward = serviceI.selectByPrimaryKey(Integer.parseInt(steId));
        //管家评分
        Evaluate evaluate = evaluateService.getBySteid(Integer.parseInt(steId));
        //管家证书
        List<Certificate> list = certificateServicel.selectsteid(Integer.parseInt(steId));

        model.addAttribute("steward",steward);
        if(evaluate!=null){
            model.addAttribute("evaluate",evaluate);
        }
        if(list.size()>0){
            model.addAttribute("certificate",list);
        }
        System.out.println(steward);
        System.out.println(evaluate);
        System.out.println(list);

        return "serverZ/yit/gjxx";
    }

}
