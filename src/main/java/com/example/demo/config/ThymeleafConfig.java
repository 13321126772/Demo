package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "thymeleaf")
public class ThymeleafConfig {

    private String path;
    private String houzhui;

    public ThymeleafConfig(String path, String houzhui) {
        this.path = path;
        this.houzhui = houzhui;
    }

    public ThymeleafConfig() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHouzhui() {
        return houzhui;
    }

    public void setHouzhui(String houzhui) {
        this.houzhui = houzhui;
    }
}
