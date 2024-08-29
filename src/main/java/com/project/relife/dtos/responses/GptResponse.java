package com.project.relife.dtos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.relife.dtos.innerDtos.Choice;
import com.project.relife.dtos.innerDtos.Usage;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class GptResponse {
    private String id;
    private String object;
    private Long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
}
