package com.assignment.spring.model;

import java.time.LocalDateTime;

public class WeatherResponse {

    private final Long id;

    private final String city;

    private final String country;

    private final Double temperature;

    private final LocalDateTime time;

    public WeatherResponse(Long id, String city, String country, Double temperature, LocalDateTime time) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.temperature = temperature;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Double getTemperature() {
        return temperature;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
