package com.project.relife.services;

import com.project.relife.repositories.InventoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService {
    private InventoryRepo inventoryRepo;

}
