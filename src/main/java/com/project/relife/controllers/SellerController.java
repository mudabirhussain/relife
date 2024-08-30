package com.project.relife.controllers;

import com.project.relife.services.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class SellerController {
    private SellerService sellerService;
}
