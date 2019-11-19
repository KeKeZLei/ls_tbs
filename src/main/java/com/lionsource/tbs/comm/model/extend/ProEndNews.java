package com.lionsource.tbs.comm.model.extend;

import lombok.Data;
import lombok.ToString;


/**
 * @ClassName ProEndNews
 * @Description 产品、新闻拓展类
 * @Author 狮源信息-谢星红
 * @Date 2019/8/30 11:58
 * @Version 1.0
 **/
@Data
@ToString
public class ProEndNews {
    private Integer id;

    private String type;

    private String title;
}
