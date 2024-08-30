package com.project.relife.dtos;

import com.project.relife.entities.InventoryEntity;
import com.project.relife.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
@Builder
public class InventoryDTO {
    private Long inventoryId;
    private String inventoryName;
    private String inventoryDescription;
    private StatusEnum statusEnum;
    private ProductDTO productDTO;
    private SellerDTO sellerDTO;

    public InventoryDTO fromEntity(@NonNull InventoryEntity inventoryEntity) {
        Objects.requireNonNull(inventoryEntity, "InventoryEntity cannot be null");
        return InventoryDTO.builder()
                .inventoryId(inventoryEntity.getInventoryId())
                .inventoryName(inventoryEntity.getInventoryName())
                .inventoryDescription(inventoryEntity.getInventoryDescription())
                .statusEnum(inventoryEntity.getStatusEnum())
                .productDTO(ProductDTO.fromEntity(inventoryEntity.getProductEntity()))
                .sellerDTO(SellerDTO.fromEntity(inventoryEntity.getSellerEntity()))
                .build();
    }
}
