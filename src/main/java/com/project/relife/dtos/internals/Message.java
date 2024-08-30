package com.project.relife.dtos.internals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private String role;
    private String content;
    private Object refusal;  // Adjust type based on actual usage
}