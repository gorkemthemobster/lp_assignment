package com.assignment.spring.mapper;

import com.assignment.spring.api.OpenWeatherResponse;
import com.assignment.spring.model.WeatherDto;
import org.springframework.stereotype.Component;

@Component
public class WeatherApiMapper {

    public WeatherDto weatherResponseToWeatherDto(OpenWeatherResponse openWeatherResponse) {
        return new WeatherDto(
                openWeatherResponse.getName(),
                openWeatherResponse.getSys().getCountry(),
                openWeatherResponse.getMain().getTemp()
        );
    }
}
