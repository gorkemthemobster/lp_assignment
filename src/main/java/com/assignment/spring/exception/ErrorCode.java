package com.assignment.spring.exception;

import java.util.HashMap;
import java.util.Map;

public interface ErrorCode {
    
    String getCode();
    
    String getMessage();
    
    Map<String, String> getProperties();
    
    static ErrorCode of(String code, String message, String... properties) {
        if (properties.length % 2 != 0) {
            throw new RuntimeException("Properties should be key/value pairs");
        }
        Map<String, String> propMap = new HashMap<>();
        for (int i = 0; i < properties.length - 1; i = i + 2) {
            propMap.put(properties[i], properties[i+1]);
        }
        return new ErrorCode() {
            @Override
            public String getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return message;
            }

            @Override
            public Map<String, String> getProperties() {
                return propMap;
            }
        };
    }
}
