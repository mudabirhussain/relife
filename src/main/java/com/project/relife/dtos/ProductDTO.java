package com.project.relife.dtos;

import com.project.relife.entities.ProductEntity;
import lombok.*;

@Data
@Builder
public class ProductDTO {
    private Long productId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private String productPriceCurrency;
    private String productCategory;
    private String productImageUrl;

    public static ProductDTO fromEntity(@NonNull ProductEntity productEntity) {
        return ProductDTO.builder()
                .productId(productEntity.getProductId())
                .productName(productEntity.getProductName())
                .productDescription(productEntity.getProductDescription())
                .productCategory(productEntity.getProductCategory())
                .productImageUrl(productEntity.getProductImageUrl())
                .productPrice(productEntity.getProductPrice())
                .productPriceCurrency(productEntity.getProductPriceCurrency())
                .build();
    }
}


