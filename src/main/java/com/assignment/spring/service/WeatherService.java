package com.assignment.spring.service;

import com.assignment.spring.exception.WeatherServiceException;
import com.assignment.spring.model.WeatherDto;

public interface WeatherService {

    WeatherDto getWeather(String city) throws WeatherServiceException;

}
