package com.project.relife.repositories;

import com.project.relife.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByProductName(String name);

    @Query("SELECT p.productPrice FROM ProductEntity p WHERE p.productId = :id")
    Optional<Long> findProductPriceById(@Param("id") Long id);

    List<ProductEntity> findAll();
}
