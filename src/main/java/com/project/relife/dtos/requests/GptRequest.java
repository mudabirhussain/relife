package com.project.relife.dtos.requests;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.relife.dtos.internals.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GptRequest implements Serializable {
    private String model;
    @JsonProperty("messages")
    private List<Message> messages;
}