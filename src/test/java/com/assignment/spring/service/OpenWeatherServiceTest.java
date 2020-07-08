package com.assignment.spring.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.assignment.spring.api.OpenWeatherResponse;
import com.assignment.spring.config.OpenWeatherConfig;
import com.assignment.spring.exception.WeatherServiceException;
import com.assignment.spring.mapper.WeatherApiMapper;
import com.assignment.spring.model.WeatherDto;

@RunWith(MockitoJUnitRunner.class)
public class OpenWeatherServiceTest {

    private static final String URL = "url";

    private static final String APP_ID = "appId";

    @InjectMocks
    private OpenWeatherService subject;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WeatherApiMapper weatherApiMapper;

    @Mock
    private OpenWeatherConfig openWeatherConfig;

    @Before
    public void doCommonMocks() {

    }

    @Test
    public void shouldReturnWeatherDataForExistingCity() throws WeatherServiceException {
        String city = "existingCity";
        String builtUrl = URL + "?" + "q=" + city + "&" + "appid=" + APP_ID;
        OpenWeatherResponse openWeatherResponse = mock(OpenWeatherResponse.class);
        WeatherDto weatherDto = mock(WeatherDto.class);
        when(openWeatherConfig.getUrl()).thenReturn(URL);
        when(openWeatherConfig.getAppId()).thenReturn(APP_ID);
        when(restTemplate.getForEntity(eq(builtUrl), eq(OpenWeatherResponse.class)))
                .thenReturn(ResponseEntity.ok(openWeatherResponse));
        when(weatherApiMapper.weatherResponseToWeatherDto(eq(openWeatherResponse)))
                .thenReturn(weatherDto);

        subject.getWeather(city);

        verify(openWeatherConfig).getUrl();
        verify(openWeatherConfig).getAppId();
        verify(restTemplate).getForEntity(eq(builtUrl), eq(OpenWeatherResponse.class));
        verify(weatherApiMapper).weatherResponseToWeatherDto(eq(openWeatherResponse));
    }

    @Test(expected = WeatherServiceException.class)
    public void shouldThrowWeatherServiceExceptionDataForNonExistingCity() throws WeatherServiceException {
        String city = "nonExistingCity";
        String builtUrl = URL + "?" + "q=" + city + "&" + "appid=" + APP_ID;
        OpenWeatherResponse openWeatherResponse = mock(OpenWeatherResponse.class);
        WeatherDto weatherDto = mock(WeatherDto.class);
        when(openWeatherConfig.getUrl()).thenReturn(URL);
        when(openWeatherConfig.getAppId()).thenReturn(APP_ID);
        when(restTemplate.getForEntity(eq(builtUrl), eq(OpenWeatherResponse.class)))
                .thenReturn(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        subject.getWeather(city);
    }

}