package com.assignment.spring.handler;

import java.util.Map;

import com.assignment.spring.mapper.ServiceExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.spring.exception.ServiceException;
import com.assignment.spring.model.ErrorResponse;

@ControllerAdvice
public class GenericExceptionHandler {

    private final ServiceExceptionMapper serviceExceptionMapper;

    @Autowired
    public GenericExceptionHandler(ServiceExceptionMapper serviceExceptionMapper) {
        this.serviceExceptionMapper = serviceExceptionMapper;
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        ErrorResponse errorResponse = serviceExceptionMapper.serviceExceptionToErrorResponse(ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
}
