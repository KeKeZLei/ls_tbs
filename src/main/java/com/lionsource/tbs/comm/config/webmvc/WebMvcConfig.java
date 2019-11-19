package com.lionsource.tbs.comm.config.webmvc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MVCConfig
 * @Description MVC配置
 * @Author 狮源信息-Jacky.zhou
 * @Date 2019/4/1 19:07
 * @Version 1.0
 **/
@Configuration
@EnableWebMvc   //开启Spring MVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);




    /**
     * @Author 狮源信息-Sunny
     * @Description 配置特定资源访问路径
     * @Date 19:09 2019/4/1
     * @Param
     * @return
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**")
                    .addResourceLocations("classpath:/static/").setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
        }
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
    }

    /**
     * @Author 狮源信息-Sunny
     * @Description SpringBoot以fastjon方式转化json数据
     * @Date 19:09 2019/4/1
     * @Param
     * @return
     **/
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //定义一个convert 转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //添加fastjson 的配置信息 比如 是否要格式化 返回的json数据
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteDateUseDateFormat
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        fastConverter.setDefaultCharset(Charset.forName("utf-8"));
        //解决乱码的问题
        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.TEXT_PLAIN);
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        converters.add(fastConverter);
    }
}
