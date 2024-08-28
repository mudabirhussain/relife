package com.project.relife.entities;

import com.project.relife.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private String productPriceCurrency;
    private String productCategory;
    private String productImageUrl;

    public static ProductEntity fromDTO(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productDTO.getProductId());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setProductDescription(productDTO.getProductDescription());
        productEntity.setProductCategory(productDTO.getProductCategory());
        productEntity.setProductImageUrl(productDTO.getProductImageUrl());
        productEntity.setProductPrice(productDTO.getProductPrice());
        productEntity.setProductPriceCurrency(productDTO.getProductPriceCurrency());
        return productEntity;
    }
}
