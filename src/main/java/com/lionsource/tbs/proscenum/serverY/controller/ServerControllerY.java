package com.lionsource.tbs.proscenum.serverY.controller;

import com.lionsource.tbs.comm.dao.ManagerMapper;
import com.lionsource.tbs.comm.dao.MemaddressMapper;
import com.lionsource.tbs.comm.model.Memaddress;
import com.lionsource.tbs.comm.model.Stewardtype;
import com.lionsource.tbs.comm.model.Tag;
import com.lionsource.tbs.proscenum.server.service.StewardtypeService;
import com.lionsource.tbs.proscenum.server.service.impl.TagServiceimpl;
import com.lionsource.tbs.proscenum.serverY.service.MemaddressMapperYI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 服务端控制器
 */
@Controller
public class ServerControllerY {
    @Autowired
    private StewardtypeService stewardtypeService;
    @Autowired
    private TagServiceimpl tagServiceimpl;
    @Autowired
    private MemaddressMapperYI mapperYI;
    /**
     * 显示所有职业
     * @param request
     * @return
     */
    @RequestMapping("/fbxp")
    public String fbxp(HttpServletRequest request, Model model) {
        List<Stewardtype> list = stewardtypeService.selectAll();
        List<Tag> tagslist = tagServiceimpl.selectAll();
        model.addAttribute("zylist",list);
        model.addAttribute("tagslist",tagslist);
        System.out.println(tagslist);
        return "serverZ/yit/fbxp";
    }

    @RequestMapping("/tests")
    public String text(Model model){
        System.out.println("进入 tests");
        List<Stewardtype> list = stewardtypeService.selectAll();
        List<Tag> tagslist = tagServiceimpl.selectAll();
        model.addAttribute("zylist",list);
        model.addAttribute("tagslist",tagslist);
        System.out.println(tagslist);
        return "serverZ/test";
    }

    @RequestMapping("/updateBy")
    public String updateByPrimaryKey(Model model,String maId){
        System.out.println("------------------"+maId);
        Memaddress memaddress = mapperYI.selectByPrimaryKey(Integer.parseInt(maId));
        System.out.println(memaddress);
        model.addAttribute("list",memaddress);
        return "serverZ/yit/updateM";
    }

    @RequestMapping("/addM")
    public String insert(){
        return "serverZ/yit/addM";
    }
}
