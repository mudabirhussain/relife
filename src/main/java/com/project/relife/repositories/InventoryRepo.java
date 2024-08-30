package com.project.relife.repositories;

import com.project.relife.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<InventoryEntity, Long> {
}
