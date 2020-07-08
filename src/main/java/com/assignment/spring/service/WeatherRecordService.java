package com.assignment.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.mapper.WeatherDtoMapper;
import com.assignment.spring.model.WeatherDto;

@Service
public class WeatherRecordService {

    private final WeatherService weatherService;

    private final WeatherDtoMapper weatherDtoMapper;

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherRecordService(WeatherService weatherService, WeatherDtoMapper weatherDtoMapper,
                                WeatherRepository weatherRepository) {
        this.weatherService = weatherService;
        this.weatherDtoMapper = weatherDtoMapper;
        this.weatherRepository = weatherRepository;
    }

    public WeatherEntity saveRecord(String city) {
        WeatherDto weatherDto = weatherService.getWeather(city);
        WeatherEntity weatherEntity = weatherDtoMapper.weatherDtoToWeatherEntity(weatherDto);
        weatherRepository.save(weatherEntity);
        return weatherEntity;
    }

}
