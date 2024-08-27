package com.project.relife.dtos.requests;

import com.project.relife.dtos.Message;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class GptRequest {

    private String model;
    private List<Message> messages;

    public GptRequest(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }
}
