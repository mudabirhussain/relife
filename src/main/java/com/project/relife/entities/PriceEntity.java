package com.project.relife.entities;

import com.project.relife.dtos.PriceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name="prices")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;
    private String priceCurrency;
    private Double priceValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    public static PriceEntity fromDTO(PriceDTO priceDTO) {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setPriceId(priceDTO.getPriceId());
        priceEntity.setPriceCurrency(priceDTO.getPriceCurrency());
        priceEntity.setPriceValue(priceDTO.getPriceValue());
        return priceEntity;
    }
}
