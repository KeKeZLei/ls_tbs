package com.lionsource.tbs.proscenum.serverY.controller;

import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.serverY.service.StewardServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.faces.annotation.RequestMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class StewardController {

    @Autowired
    private StewardServiceI serviceI;

    /**
     * 定制管家
     * @return
     */
    @RequestMapping("/dzgj")
    public void dzgj(HttpServletResponse response, String ste_worktype,String ste_workform,String ste_contracttype,String ste_workyear,String ste_expsalary,String ste_native) throws IOException {
        //乱码处理
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
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
        //调用方法
        List<Steward> list = serviceI.selectAllfbxp(ste_worktype,ste_workform,ste_contracttype,ste_workyears,ste_expsalarys,ste_native);
        PrintWriter out = response.getWriter();
        System.out.println("职位类别："+ste_worktype);
        System.out.println("是否住家："+ste_workform);
        System.out.println("管家签约形式(1=中介制,2=雇佣制)："+ste_contracttype);
        System.out.println("工作年限:"+ste_workyear);
        System.out.println("期望工资:"+ste_expsalarys);
        System.out.println("籍贯:"+ste_native);
        for (Steward i:list
             ) {
            System.out.println(i);
        }
        out.print("定制成功！");
    }

}

