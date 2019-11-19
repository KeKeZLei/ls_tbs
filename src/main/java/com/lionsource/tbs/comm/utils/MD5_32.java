package com.lionsource.tbs.comm.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5_32
 * @Description 32位MD5加密算法
 * @Author 狮源信息-Jacky.zhou
 * @Date 2018/11/17 22:59
 * @Version 1.0
 **/
public class MD5_32 {

    private static Logger logger = LoggerFactory.getLogger(MD5_32.class);

    public static String digest(String str)
    {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e){
            logger.error("MD5 encoding error!",e);
        } catch (UnsupportedEncodingException e){
            logger.error("MD5 encoding error!",e);
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++)
        {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            }else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return md5StrBuff.toString();
    }
}

