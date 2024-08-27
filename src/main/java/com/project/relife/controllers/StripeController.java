package com.project.relife.controllers;

import com.project.relife.services.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class StripeController {

    private StripeService stripeService;

    public StripeController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/intent")
    public PaymentIntent createPaymentIntent(@RequestParam long amount, @RequestParam String currency) throws StripeException {
        return stripeService.createPaymentIntent(amount, currency);
    }

    @PostMapping("/charge")
    public String createCharge(@RequestParam String token, @RequestParam long amount, @RequestParam String currency, @RequestParam String description) throws StripeException {
        return stripeService.createCharge(token, amount, currency, description).toJson();
    }
}
