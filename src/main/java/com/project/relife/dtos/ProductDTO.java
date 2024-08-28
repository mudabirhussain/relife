package com.project.relife.dtos;

import com.project.relife.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private String productPriceCurrency;
    private String productCategory;
    private String productImageUrl;

    public static ProductDTO fromEntity(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setProductDescription(productEntity.getProductDescription());
        productDTO.setProductCategory(productEntity.getProductCategory());
        productDTO.setProductImageUrl(productEntity.getProductImageUrl());
        productDTO.setProductPrice(productEntity.getProductPrice());
        productDTO.setProductPriceCurrency(productEntity.getProductPriceCurrency());
        return productDTO;
    }
}


