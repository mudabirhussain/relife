package com.project.relife.repositories;

import com.project.relife.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<SellerEntity, Long> {
}
