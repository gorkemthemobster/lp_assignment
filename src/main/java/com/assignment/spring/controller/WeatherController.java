package com.assignment.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.mapper.WeatherEntityMapper;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.service.WeatherRecordService;

@RestController
public class WeatherController {

    private final WeatherRecordService weatherRecordService;

    private final WeatherEntityMapper weatherEntityMapper;

    @Autowired
    public WeatherController(WeatherRecordService weatherRecordService, WeatherEntityMapper weatherEntityMapper) {
        this.weatherRecordService = weatherRecordService;
        this.weatherEntityMapper = weatherEntityMapper;
    }

    @GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherResponse> weather(HttpServletRequest request) {
        String city = request.getParameter("city");
        WeatherEntity weatherEntity = weatherRecordService.saveRecord(city);
        WeatherResponse weatherResponse = weatherEntityMapper.weatherEntityToWeatherResponse(weatherEntity);
        return ResponseEntity.ok(weatherResponse);
    }
}
