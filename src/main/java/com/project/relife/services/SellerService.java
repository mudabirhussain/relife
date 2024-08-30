package com.project.relife.services;

import com.project.relife.dtos.SellerDTO;
import com.project.relife.entities.SellerEntity;
import com.project.relife.repositories.SellerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerService {
    private SellerRepo sellerRepo;

    public SellerDTO registerSeller(SellerDTO sellerDTO) {
        SellerEntity sellerEntity = SellerEntity.fromDTO(sellerDTO);
        return SellerDTO.fromEntity(sellerRepo.save(sellerEntity));
    }

}
