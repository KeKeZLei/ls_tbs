package com.lionsource.tbs.comm.dao;

import com.lionsource.tbs.comm.model.Steward;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StewardMapper {
    int deleteByPrimaryKey(Integer steId);

    int insert(Steward record);

    Steward selectByPrimaryKey(Integer steId);

    List<Steward> selectAll();

    int updateByPrimaryKey(Steward record);

    //根据管家类型编号查询管家
    List<Steward> selectAllByStId(@Param("stId") String stId);

    //根据技能编号查询管家
    List<Steward> selectAllBySkillId(@Param("skillId") String skillId);

    //根据标签编号查询管家
    List<Steward> selectAllByTagId(@Param("tagId") String tagId);

    /**
     * 量身定制管家
     *  多条件查询：
     * 1职业类别
     * 2是否住家
     * 3管家签约形式(1=中介制,2=雇佣制)
     * 4工作年限
     * 5期望工资
     * 6籍贯
     * 7个人标签
     */
    List<Steward> selectAllfbxp(@Param("ste_worktype") String ste_worktype,@Param("ste_workform") String ste_workform,@Param("ste_contracttype")String ste_contracttype,@Param("ste_workyear")int ste_workyear,@Param("ste_expsalary") int ste_expsalary,@Param("ste_native") String ste_native,@Param("ste_tag") String ste_tag);

    /**
     * 从业者申请
     * @param steward
     * @return
     */
    int serverAddApply(Steward steward);

    /**
     * 查询从业者手机号码是否存在
     */
    int selectPhone(String steTel);

    /**
     * 根据用户名和手机号码进行登录
     * @param  steward
     * @return
     */
    List<Steward> getStenameStetel(Steward steward);

    /**
     * 根据手机号码进行登录
     * 短信验证
     * @param steward
     * @return
     */
    List<Steward> getStetel(Steward steward);

    /**
     * 根据电话号码查询服务人员姓名
     * @param steward
     * @return
     */
    String getStetelSteName(Steward steward);
}