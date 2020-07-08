package com.assignment.spring.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.assignment.spring.entity.WeatherEntity;
import com.assignment.spring.exception.ErrorCode;
import com.assignment.spring.exception.WeatherServiceException;
import com.assignment.spring.mapper.WeatherDtoMapper;
import com.assignment.spring.model.WeatherDto;
import com.assignment.spring.repository.WeatherRepository;

@RunWith(MockitoJUnitRunner.class)
public class WeatherRecordServiceTest {

    @InjectMocks
    private WeatherRecordService subject;

    @Mock
    private WeatherService weatherService;

    @Mock
    private WeatherDtoMapper weatherDtoMapper;

    @Mock
    private WeatherRepository weatherRepository;

    @Before
    public void clear() {
        reset(weatherService);
    }

    @Test
    public void shouldSaveAndReturnWeatherRecordWithExistingCity() {
        String city = "existingCity";
        WeatherDto weatherDto = mock(WeatherDto.class);
        WeatherEntity weatherEntity = mock(WeatherEntity.class);
        when(weatherService.getWeather(eq(city))).thenReturn(weatherDto);
        when(weatherDtoMapper.weatherDtoToWeatherEntity(eq(weatherDto))).thenReturn(weatherEntity);
        when(weatherRepository.save(weatherEntity)).thenReturn(weatherEntity);

        subject.saveRecord(city);

        verify(weatherService).getWeather(eq(city));
        verify(weatherDtoMapper).weatherDtoToWeatherEntity(eq(weatherDto));
        verify(weatherRepository).save(weatherEntity);
    }

    @Test(expected = WeatherServiceException.class)
    public void shouldThrowWeatherServiceExceptionWithNonExistingCity() {
        String city = "nonExistingCity";
        ErrorCode errorCode = ErrorCode.of("", "");
        when(weatherService.getWeather(eq(city))).thenThrow(new WeatherServiceException(errorCode));

        subject.saveRecord(city);
    }

}