package com.project.relife.dtos.innerDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Choice {
    private Integer index;
    private Message message;
    private Object logprobs;  // Adjust type based on actual usage
    @JsonProperty("finish_reason")
    private String finishReason;
}