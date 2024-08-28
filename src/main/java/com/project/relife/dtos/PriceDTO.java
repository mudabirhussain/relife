package com.project.relife.dtos;

import com.project.relife.entities.PriceEntity;
import lombok.Data;

@Data
public class PriceDTO {
    private Long priceId;
    private String priceCurrency;
    private Double priceValue;

    public static PriceDTO fromEntity(PriceEntity priceEntity) {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setPriceId(priceEntity.getPriceId());
        priceDTO.setPriceCurrency(priceEntity.getPriceCurrency());
        priceDTO.setPriceValue(priceEntity.getPriceValue());
        return priceDTO;
    }
}
