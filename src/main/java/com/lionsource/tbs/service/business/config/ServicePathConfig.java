package com.lionsource.tbs.service.business.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 服务器路配置
 *
 */
@Component
@ConfigurationProperties(prefix = "service")
@PropertySource("classpath:servicepath.properties")
@Data
@ToString
public class ServicePathConfig {
    private String path;
    private String cardPath;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
    }
}
