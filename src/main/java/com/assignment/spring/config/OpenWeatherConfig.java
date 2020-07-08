package com.assignment.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenWeatherConfig {

    @Value("${open-weather.url}")
    private String url;

    @Value("${open-weather.appId}")
    private String appId;

    public String getUrl() {
        return url;
    }

    public String getAppId() {
        return appId;
    }
}
