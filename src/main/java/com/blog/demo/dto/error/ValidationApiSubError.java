package com.blog.demo.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ValidationApiSubError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ValidationApiSubError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
