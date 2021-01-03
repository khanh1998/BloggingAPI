package com.blog.demo.dto;

import com.blog.demo.dto.error.ApiSubError;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> implements Serializable {
    private HttpStatus status;
    private boolean success;
    private T data;
    private String message;
    private List<ApiSubError> validationErrors;
}
