package com.project.relife.dtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.relife.dtos.ProductDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest {
    private Long productId;
    private Long productQuantity;
}
