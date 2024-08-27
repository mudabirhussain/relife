package com.project.relife.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public static ErrorResponse create(Exception exception, WebRequest request) {
        return new ErrorResponse(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
    }
}
