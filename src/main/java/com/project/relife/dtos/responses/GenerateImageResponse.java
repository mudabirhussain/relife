package com.project.relife.dtos.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.relife.dtos.innerDtos.GeneratedImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateImageResponse implements Serializable {
    private long created;
    private List<GeneratedImage> data;
}
