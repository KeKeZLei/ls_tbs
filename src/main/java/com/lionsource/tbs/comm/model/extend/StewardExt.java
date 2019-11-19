package com.lionsource.tbs.comm.model.extend;

import com.lionsource.tbs.comm.model.Certificate;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @ClassName StewardExt
 * @Description 管家拓展类
 * @Author 狮源信息-谢星红
 * @Date 2019/11/8 14:45
 * @Version 1.0
 **/
@Data
@ToString
public class StewardExt {
    private Integer steId;

    private Integer refId;

    private String steOpenid;

    private String steWhead;

    private String steChead;

    private String steName;

    private String steTel;

    private String steIdcardnum;

    private String steIdcardfront;

    private String steIdcardreverse;

    private String steIdcardreason;

    private Integer steSex;

    private Integer steAge;

    private String steNative;

    private String steAddress;

    private String steWorkstate;

    private String steRealnamestate;

    private Integer steContracttype;

    private Integer steWorkyear;

    private Integer steExpsalary;

    private String steWorkform;

    private String steCerstate;

    private Date steCreatetime;

    private Integer steState;

    private Integer steProvince;

    private Integer steCity;

    private String steNickname;

    private String steWorktype;

    private String steSkill;

    private String steTag;

    private String steDescribe;

    //管家证书列表
    private List<Certificate> certificateList;

    //服务态度平均分
    private Integer evaServiceAvg;

    //职业技能平均分
    private Integer evaSkillAvg;

    //职业素养平均分
    private Integer evaProqualityAvg;

    //服务用户数量
    private Integer serviceNum;

    //评价数量
    private Integer evaNum;
}
