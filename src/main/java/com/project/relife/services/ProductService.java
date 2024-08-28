package com.project.relife.services;

import com.project.relife.dtos.ProductDTO;
import com.project.relife.entities.ProductEntity;
import com.project.relife.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public ProductDTO getProductById(Long productId) throws RuntimeException{
        ProductEntity productEntity = productRepo
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductDTO.fromEntity(productEntity);
    }
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception{
        Optional<ProductEntity> productEntityOptional = productRepo.findById(productDTO.getProductId());

        if(productEntityOptional.isPresent()){
            throw new Exception("Product already exists");
        }

        return ProductDTO.fromEntity(productRepo.save(ProductEntity.fromDTO(productDTO)));
    }

    public List<ProductDTO> getProducts() throws RuntimeException{
        List<ProductDTO> productDTOS = new ArrayList<>();
        productRepo.findAll()
                .forEach(productEntity -> {
                    productDTOS.add(ProductDTO.fromEntity(productEntity));
                });
        return productDTOS;
    }

    public Optional<Long> getProductPriceByProductId(Long productId) throws RuntimeException{
        return productRepo.findProductPriceById(productId);
    }
}
