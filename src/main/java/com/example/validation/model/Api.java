package com.example.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Api<T> {

    private String resultCode;

    private String resultMessage;

    // 여기에 valid를 안 넣어주면 검증해주지 않아서 잘못된 값 들어가도 넘어가진다
    @Valid
    private T data;

    private Error error;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Error{
        private List<String> errorMessage;
    }
}
