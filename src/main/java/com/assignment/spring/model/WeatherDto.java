package com.assignment.spring.model;

public class WeatherDto {

    private final String city;

    private final String country;

    private final Double temperature;

    public WeatherDto(String city, String country, Double temperature) {
        this.city = city;
        this.country = country;
        this.temperature = temperature;
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


}
