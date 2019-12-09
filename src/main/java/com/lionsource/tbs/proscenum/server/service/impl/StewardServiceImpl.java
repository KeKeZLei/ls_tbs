package com.lionsource.tbs.proscenum.server.service.impl;

import com.lionsource.tbs.comm.dao.StewardMapper;
import com.lionsource.tbs.comm.model.Steward;
import com.lionsource.tbs.proscenum.server.service.StewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author 可可球
 * Date: Created in 2019/11/22 0022 下午 4:11
 * @Version 1.0
 */
@Service
public class StewardServiceImpl implements StewardService {
    @Autowired
    private StewardMapper stewardMapper;
    /**
     * 从业者申请
     * @param steward
     * @return
     */
    public int serverAddApply(Steward steward){
        return stewardMapper.serverAddApply(steward);
    }

    /**
     * 查询从业者手机号码是否存在
     */
    public int selectPhone(String steTel){
        return stewardMapper.selectPhone(steTel);
    }
    /**
     * 根据用户名和手机号码进行登录
     * @param  steward
     * @return
     */
    public List<Steward> getStenameStetel(Steward steward){
        return stewardMapper.getStenameStetel(steward);
    }

    /**
     * 根据手机号码进行登录
     * 短信验证
     * @param steward
     * @return
     */
    public List<Steward> getStetel(Steward steward){
        return stewardMapper.getStetel(steward);
    }
    /**
     * 根据电话号码查询服务人员姓名
     * @param steward
     * @return
     */
   public  String getStetelSteName(Steward steward){
        return stewardMapper.getStetelSteName(steward);
    }
    /**
     *根据服务人员姓名和手机号码查询个人信息
     * @param steName
     * @return
     */
    public Steward getSelectAllSteName(String steName,String ste_tel){
        return stewardMapper.getSelectAllSteName(steName,ste_tel);
    }


    /**
     * 根据用户查询管家的编号
     * @param steName
     * @return
     */
    public int getSelectOneSteId(String steName){
        return stewardMapper.getSelectOneSteId(steName);
    }

    /**
     * 根据姓名和手机号修改管家信息
     * @param steward
     * @return
     */
    public int updateByNameTel(Steward steward){
        return stewardMapper.updateByNameTel(steward);
    }
}
