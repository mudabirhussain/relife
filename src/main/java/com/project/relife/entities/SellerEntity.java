package com.project.relife.entities;

import com.project.relife.dtos.SellerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="seller")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;
    private String sellerName;
    private String sellerEmail;
    private String sellerPhone;
    private String sellerAddress;

    public static SellerEntity fromDTO(@NonNull SellerDTO sellerDTO){
        Objects.requireNonNull(sellerDTO,"sellerDTO cannot be null");
        return SellerEntity.builder()
                .sellerId(sellerDTO.getSellerId())
                .sellerName(sellerDTO.getSellerName())
                .sellerEmail(sellerDTO.getSellerEmail())
                .sellerAddress(sellerDTO.getSellerAddress())
                .sellerPhone(sellerDTO.getSellerPhone())
                .build();
    }
}
