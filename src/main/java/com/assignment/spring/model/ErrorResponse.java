package com.assignment.spring.model;

import java.util.Map;

public class ErrorResponse {

    private final String code;

    private final String message;

    private final Map<String, String> properties;

    public ErrorResponse(String code, String message, Map<String, String> properties) {
        this.code = code;
        this.message = message;
        this.properties = properties;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}
