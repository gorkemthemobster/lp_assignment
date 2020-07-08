package com.assignment.spring.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.model.WeatherDto;

@Component
public class WeatherDtoMapper {

    public WeatherEntity weatherDtoToWeatherEntity(WeatherDto weatherDto) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity(weatherDto.getCity());
        weatherEntity.setCountry(weatherDto.getCountry());
        weatherEntity.setTemperature(weatherDto.getTemperature());
        weatherEntity.setTime(LocalDateTime.now());
        return weatherEntity;
    }

}
