package com.lionsource.tbs.proscenum.server.msg;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 短信发送工具类
 *
 */
public class MobileMessageSend {
    //发送验证码的请求路径URL
    private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String APP_KEY="b3d034a61f183485e9ccf22d56c7e555";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET="6cdc53dd376e";
    //随机数
    private static final String NONCE="123456";
    //短信模板ID
    private static final String TEMPLATEID="14827082";
    //手机号
//    private static final String MOBILE="13129910000";
    //验证码长度，范围4～10，默认为4
    private static final String CODELEN="6";
    public static String sendMsg(String phone) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(SERVER_URL);

//      参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
        String curTime=String.valueOf((new Date().getTime()/1000L));
        String checkSum= CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime);

        //设置请求的header
        post.addHeader("AppKey",APP_KEY);
        post.addHeader("Nonce",NONCE);
        post.addHeader("CurTime",curTime);
        post.addHeader("CheckSum",checkSum);
        post.addHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        //设置请求参数
        List<NameValuePair> nameValuePairs =new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("mobile",phone));
        nameValuePairs.add(new BasicNameValuePair("templateid", TEMPLATEID));
        nameValuePairs.add(new BasicNameValuePair("codeLen", CODELEN));
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));

        //执行请求
        HttpResponse response=httpclient.execute(post);
        String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");

        //判断是否发送成功，发送成功返回true
        String code= JSON.parseObject(responseEntity).getString("code");

        //代码发送验证码成功 HTTP请求码  400  404  500
        if (code.equals("200")){
            String sms= JSON.parseObject(responseEntity).getString("obj");
            //这个就是发送的验证码
            System.out.println("你的短信验证码是:"+sms);
            System.out.println("发送成功！");
            return sms;
        }
        System.out.println("发送失败！");
        return "";
    }
}
