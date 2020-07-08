package com.assignment.spring.mapper;

import com.assignment.spring.exception.ServiceException;
import com.assignment.spring.model.ErrorResponse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServiceExceptionMapper {

    public ErrorResponse serviceExceptionToErrorResponse(ServiceException ex) {
        Map<String, String> props = ex.getErrorCode().getProperties();
        String message = ex.getErrorCode().getMessage();
        if (props != null) {
            for (Map.Entry<String, String> entry : props.entrySet()) {
                message = message.replace("{" + entry.getKey() + "}", entry.getValue());
            }
        }
        return new ErrorResponse(ex.getErrorCode().getCode(), message,
                ex.getErrorCode().getProperties());
    }
}
