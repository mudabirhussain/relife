package com.project.relife.dtos.responses;

import com.project.relife.dtos.Choice;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class GptResponse {
    private List<Choice> choices;

}
