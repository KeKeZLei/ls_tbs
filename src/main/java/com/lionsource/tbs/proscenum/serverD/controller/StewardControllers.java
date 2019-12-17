package com.lionsource.tbs.proscenum.serverD.controller;

import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.serverD.service.StewardServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

/**
 * TagController
 * yc
 */
@Controller
public class StewardControllers {
        @Autowired
        private StewardServiceI stewardServiceI;
        @RequestMapping("/StewardAdd")
        public String StewardAdd(@RequestParam("ste_worktype")String ste_worktype,@RequestParam("ste_name")String ste_name,@RequestParam("ste_tel")String ste_tel,@RequestParam("ste_age")int ste_age,@RequestParam("ste_workyear")int ste_workyear,@RequestParam("ste_native")String ste_native
                ,@RequestParam("ste_sex")int ste_sex,@RequestParam("ref_id")int ref_id,@RequestParam("ste_describe")String ste_describe,@RequestParam("ste_address")String ste_address,@RequestParam("ste_skill")String ste_skill,@RequestParam("ste_expsalary")int ste_expsalary){
            Date date = new Date();
            Steward steward= new Steward(0,ref_id,null,null,null,ste_name,ste_tel,null,null,null,null,ste_sex,ste_age,ste_native,ste_address,null,null,0,ste_workyear,ste_expsalary,null,null,date,0,0,0,null,ste_worktype,ste_skill,null, ste_describe);
            int count=stewardServiceI.StewardAdd(steward);
            System.err.println(steward);
            if(count>0){
                return "serverZ/registertuijianrens";
            }else {
                return "serverZ/registertuijianren";
            }
        }
}
