package com.project.relife.entities;

import com.project.relife.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    private String inventoryName;
    private String inventoryDescription;
    @Column(name="status")
    private StatusEnum statusEnum;
    private Double productSellingPrice;

    @OneToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private SellerEntity sellerEntity;

}
