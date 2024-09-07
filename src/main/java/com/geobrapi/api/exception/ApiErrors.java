package com.geobrapi.api.exception;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ApiErrors {

    private final String identificacao;
    private final Integer status;
    private final String timestamp;
    private final String title;
    private final String detail;
    private final List<Object> objects;

    @Getter
    @Builder
    public static class Object {
        private final String name;
        private final String userMessage;
    }

}
