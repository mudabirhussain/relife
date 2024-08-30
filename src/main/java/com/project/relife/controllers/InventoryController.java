package com.project.relife.controllers;

import com.project.relife.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class InventoryController {
    private SellerService sellerService;
}
