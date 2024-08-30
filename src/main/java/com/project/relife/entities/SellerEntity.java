package com.project.relife.entities;

import com.project.relife.dtos.responses.SellerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    public static SellerEntity fromDTO(SellerDTO sellerDTO){
        return SellerEntity.builder()
                .sellerId(sellerDTO.getSellerId())
                .sellerName(sellerDTO.getSellerName())
                .sellerEmail(sellerDTO.getSellerEmail())
                .sellerAddress(sellerDTO.getSellerAddress())
                .sellerPhone(sellerDTO.getSellerPhone())
                .build();
    }
}
