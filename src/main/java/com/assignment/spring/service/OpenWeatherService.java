package com.assignment.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.spring.api.OpenWeatherResponse;
import com.assignment.spring.config.OpenWeatherConfig;
import com.assignment.spring.exception.ErrorCode;
import com.assignment.spring.exception.WeatherServiceException;
import com.assignment.spring.mapper.WeatherApiMapper;
import com.assignment.spring.model.WeatherDto;

@Service
@ConditionalOnProperty(name = "service.weather", havingValue = "open-weather", matchIfMissing = true)
public class OpenWeatherService implements WeatherService {

    private final RestTemplate restTemplate;

    private final WeatherApiMapper weatherApiMapper;

    private final OpenWeatherConfig openWeatherConfig;

    @Autowired
    public OpenWeatherService(RestTemplate restTemplate, WeatherApiMapper weatherApiMapper, OpenWeatherConfig openWeatherConfig) {
        this.restTemplate = restTemplate;
        this.weatherApiMapper = weatherApiMapper;
        this.openWeatherConfig = openWeatherConfig;
    }

    @Override
    public WeatherDto getWeather(String city) throws WeatherServiceException {
        try {
            ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(buildUrl(city), OpenWeatherResponse.class);
            if (HttpStatus.OK.equals(response.getStatusCode()) && response.getBody() != null) {
                return weatherApiMapper.weatherResponseToWeatherDto(response.getBody());
            }
            throw new WeatherServiceException(
                    ErrorCode.of("OPENW01",
                            "Can't get weather data. Response code:{responseCode}",
                            "responseCode", response.getStatusCode().toString()));
        } catch (Exception e) {
            throw new WeatherServiceException(
                    ErrorCode.of("OPENW02",
                            "Can't get weather data. Cause:{cause}",
                            "cause", e.getMessage()));
        }
    }

    private String buildUrl(String city) {
        StringBuilder sb = new StringBuilder()
                .append(openWeatherConfig.getUrl())
                .append("?")
                .append("q=").append(city)
                .append("&")
                .append("appid=").append(openWeatherConfig.getAppId());
        return sb.toString();
    }
}
