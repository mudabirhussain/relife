package com.project.relife.dtos;

import com.project.relife.entities.SellerEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Builder
@Data
public class SellerDTO {
    private Long sellerId;
    private String sellerName;
    private String sellerAddress;
    private String sellerPhone;
    private String sellerEmail;

    public static SellerDTO fromEntity(@NonNull SellerEntity sellerEntity){
        Objects.requireNonNull(sellerEntity, "sellerEntity cannot be null");
        return SellerDTO.builder()
                .sellerId(sellerEntity.getSellerId())
                .sellerName(sellerEntity.getSellerName())
                .sellerAddress(sellerEntity.getSellerAddress())
                .sellerPhone(sellerEntity.getSellerPhone())
                .sellerEmail(sellerEntity.getSellerEmail())
                .build();
    }
}
