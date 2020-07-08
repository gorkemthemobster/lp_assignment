package com.assignment.spring.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.assignment.spring.exception.WeatherServiceException;
import com.assignment.spring.model.WeatherDto;

@Service
@ConditionalOnProperty(name = "service.weather", havingValue = "mock")
public class MockWeatherService implements WeatherService {
    @Override
    public WeatherDto getWeather(String city) throws WeatherServiceException {
        return new WeatherDto("Amsterdam", "The Netherlands", 27.0);
    }
}
