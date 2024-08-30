package com.project.relife.entities;

import com.project.relife.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public static ProductEntity fromDTO(@NonNull ProductDTO productDTO) {
        Objects.requireNonNull(productDTO, "productDTO cannot be null");
        return ProductEntity.builder()
                .productId(productDTO.getProductId())
                .productName(productDTO.getProductName())
                .productDescription(productDTO.getProductDescription())
                .productCategory(productDTO.getProductCategory())
                .productImageUrl(productDTO.getProductImageUrl())
                .productPrice(productDTO.getProductPrice())
                .productPriceCurrency(productDTO.getProductPriceCurrency())
                .build();
    }
}
