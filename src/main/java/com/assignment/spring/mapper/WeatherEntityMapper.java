package com.assignment.spring.mapper;

import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.model.WeatherResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherEntityMapper {
    public WeatherResponse weatherEntityToWeatherResponse(WeatherEntity weatherEntity) {
        return new WeatherResponse(
                weatherEntity.getId(),
                weatherEntity.getCity(),
                weatherEntity.getCountry(),
                weatherEntity.getTemperature(),
                weatherEntity.getTime());
    }
}
