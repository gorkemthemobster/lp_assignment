package com.assignment.spring.exception;

public class WeatherServiceException extends ServiceException{

    public WeatherServiceException(ErrorCode errorCode) {
        super(errorCode);
    }
}
